# -*- coding:utf-8 -*-
vechical ={
u'腳踏車':[u'腳踏自行車'],
u'三輪車':[u'三輪腳踏車',u'農用三輪車',u'三輪車',u'拼裝動力三輪車',u'拼裝三輪車',u'機器三輪車',u'馬達三輪車',u'摩拖三輪車',u'電動三輪車',u'動力三輪車',u'單速三輪車',u'大型三輪車',u'醫療用電三輪車',u'電動代步車',u'拼裝附動力三輪車',u'殘障三輪車',u'身心障礙者生活輔助器具特製車',u'殘障動力三輪車'],
u'小客車':[u'不明車號汽車',u'不明車輛',u'不明汽車',u'自小客',u'自小客車',u'自用小客車',u'租賃小客車',u'租賃用小客車',u'計程車',u'休旅車'],
u'輕型機車':[u'機器腳踏車',u'普通輕型機車',u'電動機車'],
u'重型機車':[u'警用重型機車',u'重型機車',u'普通重機車',u'普通重型機車',u'電動重型機車'],
u'大客車':[u'遊覽車',u'出租遊覽車',u'大客車',u'營業大客車',u'公車',u'客運'],
u'農用車':[u'農耕機',u'農耕曳引機',u'農耕曳引車',u'農耕用車'],
u'火車':[u'火車',u'電力機車'],
u'貨車':[u'小貨車',u'小客貨車',u'廂型貨車',u'大貨車'],
u'聯結車':[u'曳引車',u'全拖車',u'貨櫃車',u'聯結車'],
u'拖板車':[u'拖板車',u'電動拖板車']
}
print 'dic vechical set'

def search_vechical(vechical,content):
    num = 0
    for v in vechical.keys():
        for i in vechical[v]:
            if i in content:
                #print x,i
                num += 1
#     print 'search_vechical - %d'%num
    return 1 if num > 1 else 0

print 'def search_vechical(vechical,content) set'

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
                
                # total_get += search_costs(costs,content)
                total_get += search_vechical(vechical,content)
                # total_get += search_law(law,content)
                # total_get += search_weather(weather,content)
                # total_get += search_situation(situation,content)
                if total_get >0:
#                     print x,total_get
                    total+= 1
#                 print '-------------'
    return total,len(os.listdir(all_files)),(total+0.0)*100/len(os.listdir(all_files))
print 'def run(pos) set\n'

find_number = 0
total_number = 0
with codecs.open('search_vechical.txt','a','utf-8') as fr:
    for pos in ls:
        fr.write('%s - '%pos)
        print '%s'%pos
        fr.write('find number - %d ; total number - %d ; rate - %0.1f %% \r\n'%run(pos))
        result = 'find number - %d ; total number - %d ; rate - %0.1f %%'%run(pos)
        print result
        find_number += int(result.split(u'-')[1].split(u';')[0].strip())
        total_number += int(result.split(u'-')[2].split(u';')[0].strip())
    fr.write('total_find - %d ; total - %d ; rate - %0.1f %%'%(find_number,total_number,(find_number+0.0)*100/total_number))

