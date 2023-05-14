import paddlehub as hub
import cv2, os
from tqdm import tqdm
import numpy as np
imgs = []
img_list = os.listdir('data/crop')
img_list.sort()
for img in img_list:
    img = os.path.join('data/crop',img)
    img = cv2.imread(img)
    imgs.append(img)

imgs = np.array(imgs)

count_ture = 0
count_false = 0
for x in tqdm(range(480)):
    same = imgs[x*25:x*25+25,:,:,:]
    for img in same:
        for _img in same:
            new_img = np.concatenate([img,_img],1)
            cv2.imwrite(os.path.join('data/train/true','%06d.jpg' % count_ture),new_img)
            count_ture += 1
        for _ in range(25):
            while True:
                index = np.random.randint(0, 12000)
                if index not in range(x*25,x*25+25):
                    break
            new_img = np.concatenate([img,imgs[index]],1)
            cv2.imwrite(os.path.join('data/train/false','%06d.jpg' % count_false),new_img)
            count_false += 1

for x in tqdm(range(480,490)):
    same = imgs[x*25:x*25+25,:,:,:]
    for img in same:
        for _img in same:
            new_img = np.concatenate([img,_img],1)
            cv2.imwrite(os.path.join('data/dev/true','%06d.jpg' % count_ture),new_img)
            count_ture += 1
        for _ in range(25):
            while True:
                index = np.random.randint(12000, 12250)
                if index not in range(x*25,x*25+25):
                    break
            new_img = np.concatenate([img,imgs[index]],1)
            cv2.imwrite(os.path.join('data/dev/false','%06d.jpg' % count_false),new_img)
            count_false += 1

for x in tqdm(range(490,500)):
    same = imgs[x*25:x*25+25,:,:,:]
    for img in same:
        for _img in same:
            new_img = np.concatenate([img,_img],1)
            cv2.imwrite(os.path.join('data/test/true','%06d.jpg' % count_ture),new_img)
            count_ture += 1
        for _ in range(25):
            while True:
                index = np.random.randint(12250, 12500)
                if index not in range(x*25,x*25+25):
                    break
            new_img = np.concatenate([img,imgs[index]],1)
            cv2.imwrite(os.path.join('data/test/false','%06d.jpg' % count_false),new_img)
            count_false += 1