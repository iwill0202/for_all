# -*- coding:utf-8 -*-
'''
for isolation useless virdict

********請先在project 資料夾裡 創建一個 isolation  資料夾**********
'''
ls = [u'臺北',u'士林',u'新北',u'宜蘭'\
     ,u'基隆',u'桃園',u'新竹',u'苗栗'\
     ,u'臺中',u'彰化',u'南投',u'雲林'\
     ,u'嘉義',u'臺南',u'高雄',u'花蓮'\
     ,u'臺東',u'屏東',u'澎湖',u'金門'\
     ,u'連江']
import os
import codecs

def isolation(pos):
    try :
        place = pos
        location = u'project\\%s\\'%place
        all_files = os.path.abspath(location)
        for x in os.listdir(all_files):
            if x[0]!=u'c' and x[0]!=u'W':
    #             print x
                with codecs.open(os.path.join(location,x),'r','utf-8') as f:
                    content = f.read()
                    # 有「停車場」但沒有「『車禍』或『交通事故』」
                if u'停車場' in content and (u'車禍' not in content and u'交通事故' not in content):
                        #假如在裡面 用 os.rename 把原來的檔案 移到 project 裡的一個資料夾 isolation
                    os.rename(os.path.join(u"C:\\Users\\BigData\\Desktop\\python\\",location,x),
                             os.path.join(u'C:\\Users\\BigData\\Desktop\\python\\project\\isolation',x))
                    print x
                        
    except Exception as e :
        print e

print 'def isolation(pos) set'

for i in ls:
    isolation(i)

print 'done'