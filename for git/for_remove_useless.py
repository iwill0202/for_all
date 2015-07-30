# -*- coding:utf-8 -*-
ls = [u'臺北',u'士林',u'新北',u'宜蘭'\
     ,u'基隆',u'桃園',u'新竹',u'苗栗'\
     ,u'臺中',u'彰化',u'南投',u'雲林'\
     ,u'嘉義',u'臺南',u'高雄',u'花蓮'\
     ,u'臺東',u'屏東',u'澎湖',u'金門'\
     ,u'連江']
import os 
import codecs

def cut_useless(pos):
    num = 0
    location = 'project\\%s'%pos
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        if x[0]==u'c' or x[0]==u'W':
            print x
            num+=1
            os.remove(os.path.join(location,x))
    return num
total = 0
for pos in ls:
    total += cut_useless(pos)
print total
print 'done'