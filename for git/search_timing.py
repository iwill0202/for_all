# -*- coding:utf-8 -*-
timing = [u'凌晨',u'晚間',u'零時',u'晚上',u'上午',u'下午',u'中午',u'早上']
print 'dic timing set'

def search_timing(timing,content):
    num = 0
    for v in timing:
        if v in content:
            num += 1
            break
#     print 'search_situation - %d'%num
    return 1 if num > 0 else 0

print 'def search_timing(timing,content) set'

ls = [u'臺北',u'士林',u'新北',u'宜蘭'\
     ,u'基隆',u'桃園',u'新竹',u'苗栗'\
     ,u'臺中',u'彰化',u'南投',u'雲林'\
     ,u'嘉義',u'臺南',u'高雄',u'花蓮'\
     ,u'臺東',u'屏東',u'澎湖',u'金門'\
     ,u'連江']
import os
import codecs

def run(pos):
    import os
    import codecs
    place = pos
    total = 0
    location = 'project\%s\\'%place
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        if x[0]!= u'c' and x[0]!= u'W':
            with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
                total_get = 0
                content = f.read()
                                
                total_get += search_timing(timing,content)

                if total_get > 0:
#                     print x,total_get
                    total+= 1
#                 print '-------------'
    return total,len(os.listdir(all_files)),(total+0.0)*100/len(os.listdir(all_files))
print 'def run(pos) set\n'

with codecs.open('search_timing.txt','a','utf-8') as fr:
    for pos in ls:
        fr.write('%s - '%pos)
        print '%s'%pos
        fr.write('find number - %d ; total number - %d ; rate - %0.1f %% \r\n'%run(pos))
        print 'find number - %d ; total number - %d ; rate - %0.1f %%'%run(pos)