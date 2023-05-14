from django.shortcuts import render,HttpResponse,redirect
import cv2, threading
from inference import AnalysisModel
from preprocess import pre_det, pre_val
from postprocess import post_det
import pymysql
from tkinter import Tk, Button
import numpy as np
from PIL import Image
from matplotlib import pyplot as plt
import pymysql
from paddle.fluid.core import AnalysisConfig
from paddle.fluid.core import create_paddle_predictor
import os
import datetime
os.environ['KMP_DUPLICATE_LIB_OK'] = 'True'


def concatenate(true_img, crop):
    new = np.concatenate([true_img,crop],1)
    return new

# 数据预处理
def pre_val(img):
    img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
    img = Image.fromarray(img)

    # 图像缩放
    image = img.resize((224, 224), Image.LANCZOS)

    # HWC to CHW
    mean = np.array([0.485,0.456,0.406]).reshape(3, 1, 1)
    std = np.array([0.229,0.224,0.225]).reshape(3, 1, 1)
    image = np.array(image).astype('float32')
    if len(image.shape) == 3:
        image = np.swapaxes(image, 1, 2)
        image = np.swapaxes(image, 1, 0)

    # 归一化
    image /= 255
    image -= mean
    image /= std
    image = image[[0, 1, 2], :, :]
    image = np.expand_dims(image, axis=0).astype('float32')
    return image

# 创建预测器
def create_predictor(model_file, params_file):
    # 创建配置
    config = AnalysisConfig(model_file, params_file)
    # 关闭GPU
    config.disable_gpu()
    # 开启mkldnn加速intel平台的CPU推理速度
    config.enable_mkldnn()
    # 关闭log显示
    config.disable_glog_info()
    # 开启ir优化
    config.switch_ir_optim(True)
    # 不使用feed和fetch的算子
    config.switch_use_feed_fetch_ops(False)
    # 根据配置创建预测器
    predictor = create_paddle_predictor(config)
    return predictor

# 模型预测
def predict_val(predictor, inputs):
    # 获取输入向量名
    input_names = predictor.get_input_names()
    # 根据输入向量名获取输入向量
    input_tensor = predictor.get_input_tensor(input_names[0])
    # 将输入数据拷贝进输入向量
    input_tensor.copy_from_cpu(inputs)
    # 执行前向计算
    predictor.zero_copy_run()
    # 获取输出向量名
    output_names = predictor.get_output_names()
    # 根据输出向量名获取输出向量
    output_tensor = predictor.get_output_tensor(output_names[0])
    # 从输出向量中拷贝输出数据到输出变量上
    output_data = output_tensor.copy_to_cpu()
    return output_data

def facerecognize():
    conn = pymysql.connect(host='127.0.0.1'  # 连接名称，默认127.0.0.1
                           , user='root'  # 用户名
                           , passwd=''  # 密码
                           , port=3306  # 端口，默认为3306
                           , db='logistics'  # 数据库名称
                           , charset='utf8'  # 字符编码
                           )
    cur = conn.cursor()  # 生成游标对象
    sql = "UPDATE attendance SET attendance='已签', aDate="  # SQL语句
    conditional = "WHERE attendance.Uid in(SELECT auserinfo.Uid from auserinfo where photoname="
    predictor = create_predictor('inference/face_verification/__model__', 'inference/face_verification/__params__')

    # 读取图片
    files = []
    img = []
    img_true = []
    img_true2 = []
    new = []
    img1 = cv2.imread('img/temp.jpg')
    path = "img"
    if os.path.exists(path):
        files.extend(os.listdir(path))
        print(files)
        for i in files:
            if i != 'temp.jpg':
                k = 'img/' + i
                new.append(i)
                img.append(cv2.imread(k))
        '''img1 = cv2.imread('img/crop_0.jpg')
    img2 = cv2.imread('img/lys.jpg')
    img3 = cv2.imread('img/lys01.jpg')
    img4 = cv2.imread('img/lxh.jpg')'''
        # 图像拼接
        for i in img:
            img_true.append(concatenate(img1, i))
        # img_false = concatenate(img2, img1)

        # 输入图片展示
        '''plt.imshow(img_true[:,:,::-1])
    plt.show()
    plt.imshow(img_false[:,:,::-1])
    plt.show()'''

        # 数据预处理
        for i in img_true:
            img_true2.append(pre_val(i))
    # img_false = pre_val(img_false)

    # 数据拼接
    imgs = np.concatenate([i for i in img_true2], 0)
    # print(imgs)
    # 模型预测
    output_data = predict_val(predictor, imgs)

    # 结果后处理
    results = np.argmax(output_data, 1)
    hh = 0
    for i, result in enumerate(results):
        if result:
            print('第%d个样本匹配' % (i + 1))
            print(new[i])
            hh = 1
            x = datetime.datetime.now()
            print(x)
            sql1 = sql + "'" + str(x) + "'" + conditional + "'" + new[i] + "')"
            print(sql1)
            cur.execute(sql1)  # 执行SQL语句
            conn.commit()
        else:
            print('第%d个样本不匹配' % (i + 1))

    if hh == 0:
        global ansres
        ansres = '{"data":"fail"}'
    cur.close()  # 关闭游标
    conn.close()  # 关闭连接


def change_face():
    global change_flag
    change_flag = True


def main():
    global change_flag
    cap = cv2.VideoCapture(0)
    model_det = AnalysisModel('inference/face_detection/__model__',
                              'inference/face_detection/__params__',
                              True,
                              False)

    model_val = AnalysisModel('inference/face_verification/__model__',
                              'inference/face_verification/__params__',
                              False,
                              True)
    tmp = None
    font = cv2.FONT_HERSHEY_SIMPLEX
    while True:
        sucess, img = cap.read()
        img_det = pre_det(img, 0.3)
        result_det = model_det.predict_det(img_det)
        img, crops, bboxes = post_det(img, result_det)
        if type(tmp) is np.ndarray:
            for crop, bbox in zip(crops, bboxes):
                img_val = pre_val(tmp, crop)
                x1, y1 = bbox[:2]
                result_val = model_val.predict_val(img_val)
                if np.argmax(result_val[0]):
                    img = cv2.putText(img, 'Success', (x1, y1 - 4), font, 0.6, (0, 255, 0), 2)
                else:
                    img = cv2.putText(img, 'Faild', (x1, y1 - 4), font, 0.6, (0, 0, 255), 2)
        if (len(crops) > 0) and change_flag:
            tmp = crops[0]
            crop = crops[0]
            cv2.imshow('Face', crop)
            change_flag = False
            cv2.imwrite('img/temp.jpg', crop)

        cv2.imshow('Face recognition', img)
        k = cv2.waitKey(1)
        if k == 27:
            # 通过esc键退出摄像
            cv2.destroyAllWindows()
            break

def home(request):
    if request.method=="GET":
        return render(request,'home.html')


def solve(request):
    if request.method=="POST":
        global change_flag
        change_flag = False
        global ansres
        ansres = '{"data":"success"}'
        root = Tk()
        root.title('Button')
        button = Button(root, text="点击抓取人脸图片", command=change_face)
        button.pack()
        main_thread = threading.Thread(target=main)
        main_thread.start()
        root.mainloop()
        facerecognize()
        return HttpResponse(ansres)
def upload(request):
    if request.method=="GET":
        return render(request,'upload.html')
    if request.method=="POST":
        uid = request.POST['uid']
        postname = request.POST['name']
        model_det = AnalysisModel('inference/face_detection/__model__',
                                  'inference/face_detection/__params__',
                                  True,
                                  False)

        # 读取图片
        img = cv2.imread('upload/'+postname)

        # 原始图片展示

        img_det = pre_det(img, 0.3)
        result_det = model_det.predict_det(img_det)
        img, crops, bboxes = post_det(img, result_det)

        cv2.imwrite('img/'+postname, crops[0])
        ansres = '{"data":"success"}'
        conn = pymysql.connect(host='127.0.0.1'  # 连接名称，默认127.0.0.1
                               , user='root'  # 用户名
                               , passwd=''  # 密码
                               , port=3306  # 端口，默认为3306
                               , db='logistics'  # 数据库名称
                               , charset='utf8'  # 字符编码
                               )
        cur = conn.cursor()  # 生成游标对象
        sql = "UPDATE auserinfo SET photoname='"+postname+"' WHERE Uid='"+uid+"'"  # SQL语句
        cur.execute(sql)  # 执行SQL语句
        conn.commit()
        cur.close()  # 关闭游标
        conn.close()  # 关闭连接
        return HttpResponse(ansres)
def rec(request):
    if request.method=="GET":
        return render(request,'rec.html')

def test(request):
    if request.method=="POST":
        print("test")
        postname = request.POST['name']
        model_det = AnalysisModel('inference/face_detection/__model__',
                                  'inference/face_detection/__params__',
                                  True,
                                  False)

        # 读取图片
        img = cv2.imread('upload/'+postname)

        # 原始图片展示

        img_det = pre_det(img, 0.3)
        result_det = model_det.predict_det(img_det)
        img, crops, bboxes = post_det(img, result_det)
        cv2.imwrite('img/temp.jpg', crops[0])
        global ansres
        ansres = '{"data":"success"}'
        facerecognize()
        return HttpResponse(ansres)
# import math
# import os
# import pandas as pd
#
#
# # 计算两个向量的余弦相似度
# def cos_similarity(vec_dim, vector_1, vector_2):  # 输入两个向量
#     # 计算两个向量的点积
#     x = 0
#     i = 0
#     # vec_dim = len(vector_1)  # 向量维度
#     while i < vec_dim:
#         x = x + vector_1[i] * vector_2[i]
#         i = i + 1
#
#     # 计算两个向量的模
#     i = 0
#     sq_1 = 0
#     sq_2 = 0
#     while i < vec_dim:
#         sq_1 = sq_1 + vector_1[i] * vector_1[i]  # pow(a,2)
#         sq_2 = sq_2 + vector_2[i] * vector_2[i]
#         i = i + 1
#
#     result = float(x) / (math.sqrt(sq_1) * math.sqrt(sq_2))
#     return result
#
#
# def get_embeddings(path):
#     with open(path, encoding='utf8') as f:
#         data = f.read().splitlines()  # 逐行读取文件，并去除回车，输出['','',...,]
#
#     row = data[0].split()[0]  # embedding的行数
#     col = data[0].split()[1]  # embedding的列数
#     dim = int(col)
#
#     i = 1
#     embeddings = []
#     while i < int(row):
#         # item_list = []
#         item = data[i].split(' ')
#         word = item[0]
#         embedding = item[1:]
#         embedding = list(map(eval, embedding))
#         # item_list.append(word)
#         embeddings.append(embedding)
#         i += 1
#     # embeddings.append(item_list)  # item_list[0]为关键词，item_list[1]为embedding
#     return embeddings, dim
#
#
# def find_each(path):
#     path_list = []
#     files_dir = os.listdir(path)
#     for file in files_dir:
#         file_path = os.path.join('%s\%s' % (path, file))
#         path_list.append(file_path)
#     return path_list
#
#
# def get_sim_matrix(path_1, path_2):  # 输入单embedding的路径
#     # 获得两个embeddings数据
#     embeddings_1, vec_dim_1 = get_embeddings(path_1)
#     embeddings_2, vec_dim_2 = get_embeddings(path_2)
#
#     # 生成词向量相似度矩阵
#     if vec_dim_1 == vec_dim_2:
#         matrix = []
#         for em_1 in embeddings_1:
#             score = []
#             for em_2 in embeddings_2:
#                 cos_sim = cos_similarity(vec_dim_1, em_1, em_2)
#                 score.append(cos_sim)  # embeddings1中第i个embedding与embeddings2中每个embedding的相似度值
#             matrix.append(score)
#     else:
#         print('input error: the dimensions are different')
#     return matrix
#
#
# # 卷积层,卷积核的感受野为2*2，参数表示一个输入词向量矩阵
# def cnn_folding(dict_vec):
#     c = len(dict_vec[1])  # 获取输入矩阵的横向长度
#     r = len(dict_vec)  # 获取输入矩阵的纵向长度
#     result = [[0 for col in range(c-1)] for row in range(r-1)]  # python构造的二维列表
#     for i in range(r-1):  # 通过循环实现整个矩阵的运算
#         for j in range(c-1):
#             re = (dict_vec[i][j] + dict_vec[i][j+1] + dict_vec[i+1][j] +
#                   dict_vec[i+1][j+1])/4  # 实现卷积层的运算，这里卷积核默认是[[1,1],[1,1]]
#             result[i][j] = re
#     return result
#
#
# # 池化层，采用max-pooling方式实现池化，参数表示输入矩阵
# def cnn_pooling(dict_pooling):
#     c = len(dict_pooling[1])
#     r = len(dict_pooling)
#     result = [[0 for col in range(c - 1)] for row in range(r - 1)]  # python构造的二维列表
#     for i in range(r - 1):
#         for j in range(c - 1):
#             re = max(dict_pooling[i][j], dict_pooling[i][j + 1], dict_pooling[i + 1][j],
#                      dict_pooling[i + 1][j + 1])  # max-pooling方法实现池化
#             result[i][j] = re
#     return result
#
#
# # 实现卷积层和池化层的连接层
# def pooling_folding(matrix):
#     res = []
#     data_list = matrix
#     while 1:  # 交替实现卷积层和池化层
#         c = len(data_list[0])
#         r = len(data_list)
#         if c == 1 or r == 1:  # 判定池化层跳出循环条件
#             for i in range(len(data_list)):
#                 for j in data_list[i]:
#                     res.append(j)
#             break
#         pool = cnn_pooling(data_list)  # 实现池化层
#         if len(pool) == 1 or len(pool[1]) == 1:  # 判定卷积层跳出循环的条件
#             data_list = pool
#             for i in range(len(data_list)):
#                 for j in data_list[i]:
#                     res.append(j)
#             break
#         else:
#             fold = cnn_folding(pool)  # 实现卷积层
#             data_list = fold
#             pool = [[0 for col in range(c - 1)] for row in range(r - 1)]
#             fold = [[0 for col in range(c - 1)] for row in range(r - 1)]
#     return res
#
#
# jd_path = r'D:\thesis\0811\jd_graph\graph_embeddings'
# user_path = r'D:\thesis\0811\user_graph\graph_embeddings'
# jd_em_paths = find_each(jd_path)  # 得到目录下的
# user_em_paths = find_each(user_path)
# job_list = []
# sim_lists = []
# for jd_file in jd_em_paths:
#     sim_dict = {}
#
#     jd_file_name = os.path.basename(jd_file)
#     jd_name = jd_file_name.split('.')[0]  # jd的类型名称
#     job_list.append(jd_name)
#
#     for user_file in user_em_paths:
#         sim_matrix = get_sim_matrix(jd_file, user_file)  # 行代表job的embedding，列代表user的embedding，值为两个embedding的相似度
#         sim_res = pooling_folding(sim_matrix)  # 送入卷积、池化层，全连接
#         sim_score = sum(sim_res)/len(sim_res)  # 求和平均
#
#         user_file_name = os.path.basename(user_file)
#         user_name = user_file_name.split('.')[0]  # user id
#
#         sim_dict.update({user_name: sim_score})  # 或.update(b=2) # 每个岗位与各用户的相似度
#     sim_list = sorted(zip(sim_dict.values(), sim_dict.keys()), reverse=True)  # 降序排列
#     sim_list = sim_list[:100]  # 取前100个
#
#     sim_lists.append(sim_list)
#
# df = pd.DataFrame()
# df['jd_sub_type'] = job_list
# df['sim_users'] = sim_lists
# df.to_csv("../data/jd_user_sim_2.csv", encoding="utf8", index=None, header=True)  # 写入文件，每个岗位与各用户的相似度
#
# # df = pd.read_csv("../data/jd_user_sim.csv", encoding='utf8', header=0)  # 读取文件
