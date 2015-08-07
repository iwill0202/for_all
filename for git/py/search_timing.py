# -*- coding:utf-8 -*-
timing = {u'夜間':[u'凌晨',u'晚間',u'零時',u'晚上',u'半夜',u'夜半',u'夜晚',u'零晨',u'午夜',u'淩晨',u'深夜',u'晚11時',u'晚8時',u'晚6時',u'晚7時',u'晚二十一時',u'晚九時',u'晚十一時',u'晚六時',u'晚22時',u'晚9時',u'晚10時',u'夜晚0時'],
u'日間':[u'上午',u'下午',u'中午',u'早上',u'傍晚',u'早晨',u'清晨',u'晨五時',u'晨5時',u'晨間',u'午間',u'午四時',u'午4時',u'午22時',u'午二十二時',u'近午時間',u'正午',u'上許',u'上9時',u'上九時',u'上五8時',u'白天',u'日間'],
}
print 'dic timing set'

def search_timing(timing,content):
    num = 0
    for t in timing.keys():
        for s in timing[t]:
            if s in content:
                num += 1
                break
#     print 'search_situation - %d'%num
    return 1 if num == 2 else 0

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
                print x
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