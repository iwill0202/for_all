# -*- coding:utf-8 -*-
time = {
u'夜間':[u'凌晨',u'晚間',u'零時',u'晚上',u'半夜',u'夜半',u'夜晚',u'零晨',u'午夜',u'淩晨',u'深夜',u'晚11時',u'晚8時',u'晚6時',u'晚7時',u'晚二十一時',u'晚九時',u'晚十一時',u'晚六時',u'晚22時',u'晚9時',u'晚10時',u'夜晚0時'],
u'日間':[u'上午',u'下午',u'中午',u'早上',u'傍晚',u'早晨',u'清晨',u'晨五時',u'晨5時',u'晨間',u'午間',u'午四時',u'午4時',u'午22時',u'午二十二時',u'近午時間',u'正午',u'上許',u'上9時',u'上九時',u'上五8時',u'白天',u'日間']
}
weather = {
u'晴':[u'天氣晴',u'天氣晴朗',u'晴朗無雨',u'無雨天氣',u'天氣晴朗且視距良好',u'天氣良好',u'日間天氣晴',u'晨間天氣晴朗',u'無風無雨',u'日間自然光線'],
u'雨':[u'天氣雨',u'天氣均為雨',u'有雨之天氣'u'天氣微雨',u'夜間有雨',u'陰雨',u'下雨不斷'],
u'陰':[u'天氣陰'],
u'高溫':[u'氣溫甚高',u'天氣酷熱',u'天氣炎熱'],
u'霧':[u'天氣起霧',u'夜間雨霧視線不清',u'雨霧',u'濃霧',u'起霧',u'煙霧'],
u'昏暗':[u'天氣昏暗',u'夜間雨霧視線不清',u'天氣陰沉無月光',u'隧道內光線不足',u'夜間有雨',u'夜間無照明',u'天色陰暗',u'能見度低']
}

wanted = {
u'夜間':[u'凌晨',u'晚間',u'零時',u'晚上',u'半夜',u'夜半',u'夜晚',u'零晨',u'午夜',u'淩晨',u'深夜',u'晚11時',u'晚8時',u'晚6時',u'晚7時',u'晚二十一時',u'晚九時',u'晚十一時',u'晚六時',u'晚22時',u'晚9時',u'晚10時',u'夜晚0時'],
u'昏暗':[u'天氣昏暗',u'夜間雨霧視線不清',u'天氣陰沉無月光',u'隧道內光線不足',u'夜間有雨',u'夜間無照明',u'天色陰暗',u'能見度低']
}

def search_situation(wanted,content):
    num = 0
    for v in wanted.keys():
        for i in wanted[v]:
            if i in content:
                num += 1
                continue
    if num==2:
      return 1
    else:
      return 0

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
    total_get=0
    place = pos
    location = 'project\%s\\'%place
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        if x[0]!= u'c' and x[0]!= u'W':
            with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
                content = f.read().replace(u' ','').replace(u'　','').replace(u'\r','').replace(u'\n','')
                answer = search_situation(weather,content)
                if answer==1:
                    print x
                total_get += answer
                # total_get += search_situation(situation,content)
#                 print '-------------'
    return total_get,len(os.listdir(all_files))
print 'def run(pos) set\n'
import time
before = time.time()
total = 0
all_ff = 0
for pos in ls:
    (t,a)=run(pos)
    total+=t
    all_ff+=a
    print pos,total,all_ff

print total,all_ff
print '%.2f'%((total+0.0)/all_ff)
print time.time()-before
    