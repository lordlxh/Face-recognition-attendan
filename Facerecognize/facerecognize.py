import cv2
import numpy as np
from PIL import Image
from  matplotlib import pyplot as plt
import pymysql
from paddle.fluid.core import AnalysisConfig
from paddle.fluid.core import create_paddle_predictor
import os
import datetime

os.environ['KMP_DUPLICATE_LIB_OK'] = 'True'
conn=pymysql.connect(host = '127.0.0.1' # 连接名称，默认127.0.0.1
,user = 'root' # 用户名
,passwd='' # 密码
,port= 3306 # 端口，默认为3306
,db='logistics' # 数据库名称
,charset='utf8' # 字符编码
)
cur = conn.cursor() # 生成游标对象
sql="UPDATE attendance SET attendance='已签', aDate=" # SQL语句
conditional="WHERE attendance.Uid in(SELECT auserinfo.Uid from auserinfo where photoname="

# 图片拼接
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

# 实例化检测模型预测器
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
        if i!='temp.jpg':
            k = 'img/'+i
            new.append(i)
            img.append(cv2.imread(k))
    '''img1 = cv2.imread('img/crop_0.jpg')
img2 = cv2.imread('img/lys.jpg')
img3 = cv2.imread('img/lys01.jpg')
img4 = cv2.imread('img/lxh.jpg')'''
# 图像拼接
    for i in img:
        img_true.append(concatenate(img1, i))
#img_false = concatenate(img2, img1)

# 输入图片展示
    '''plt.imshow(img_true[:,:,::-1])
plt.show()
plt.imshow(img_false[:,:,::-1])
plt.show()'''

# 数据预处理
    for i in img_true:
        img_true2.append(pre_val(i))
#img_false = pre_val(img_false)

# 数据拼接
imgs = np.concatenate([i for i in img_true2], 0)
#print(imgs)
# 模型预测
output_data = predict_val(predictor, imgs)

# 结果后处理
results = np.argmax(output_data, 1)
hh=0

for i, result in enumerate(results):
    if result:
        print('第%d个样本匹配' % (i+1))
        print(new[i])
        hh=1
        x=datetime.datetime.now()
        print(x)
        sql1 = sql+"'"+str(x)+"'"+conditional+"'"+new[i]+"')"
        print(sql1)
        cur.execute(sql1)  # 执行SQL语句
        conn.commit()
    else:
        print('第%d个样本不匹配' % (i+1))

if hh==0:
    global ansres
    ansres='{"data":"fail"}'
cur.close() # 关闭游标
conn.close() # 关闭连接