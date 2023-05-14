

import cv2
import numpy as np
from inference import AnalysisModel
from preprocess import pre_det, pre_val
from postprocess import post_det

import os
os.environ['KMP_DUPLICATE_LIB_OK'] = 'True'

# 数据预处理

# 数据后处理
# 输入原始图像，根据预测结果绘制人脸预测框，并裁剪人脸图像


# 创建预测器


# 模型预测


# 实例化检测模型预测器
model_det = AnalysisModel('inference/face_detection/__model__',
                              'inference/face_detection/__params__',
                              True,
                              False)


# 读取图片
img = cv2.imread('upload/sun1.jpg')
cv2.imshow('Face recognition', img)
# 原始图片展示

img_det = pre_det(img, 0.3)
result_det = model_det.predict_det(img_det)
img, crops, bboxes = post_det(img, result_det)
print(crops)
cv2.imshow('Face recognition', crops[0])
cv2.imwrite('img/sun2.jpg', crops[0])
# for crop, bbox in zip(crops, bboxes):
#     img_val = pre_val(img, crop)
#     x1, y1 = bbox[:2]
#     result_val = model_val.predict_val(img_val)
#     cv2.imwrite('img/sun02.jpg', crops[0])

