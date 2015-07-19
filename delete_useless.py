import os
import codecs
ls = [u'臺北',u'士林',u'新北',u'宜蘭'\
     ,u'基隆',u'桃園',u'新竹',u'苗栗'\
     ,u'臺中',u'彰化',u'南投',u'雲林'\
     ,u'嘉義',u'臺南',u'高雄',u'花蓮'\
     ,u'臺東',u'屏東',u'澎湖',u'金門'\
     ,u'連江']

place = pos

location = 'project\%s\\'%place
all_files = os.path.abspath(location)
for x in os.listdir(all_files)[:10]:
    total = 2
    if x[0]!= u'c' and x[0]!= u'W':
        total -=1
        if x not in not_choose_in_verdict:
            
            total +=1
        if total ==2:
            print x