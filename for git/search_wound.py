# -*- coding:utf-8 -*-
wound = [u'大量出血',u'內出血',u'化學性燒燙傷',u'化學性燒燙傷',u'水腦症',u'出血',u'出血性休克',u'外傷',u'外傷性腦出血',u'甩鞭式傷害',u'多處擦傷',u'肌肉拉傷',u'肌肉異常',u'肌肉痙攣壓痛',u'肌肉較緊感',u'肌張力異常症',u'肌腱炎',u'血氣胸',u'血胸',u'血腫',u'吸入性肺損傷',u'坐骨神經痛',u'扭傷',u'折出血休克',u'受傷',u'呼吸衰竭',u'拉傷',u'肢體偏癱',u'表淺損傷',u'青光眼',u'活動受到侷限',u'穿刺性骨折',u'紅腫',u'重度脫臼',u'挫傷',u'挫擦傷',u'浮腫',u'疼痛',u'病變',u'眩暈',u'破裂',u'破損',u'神經根受損',u'神經根病變',u'神經根病變傷害',u'神經麻痺',u'神經損傷',u'神經壓迫',u'神經叢病變',u'粉碎性骨折',u'缺氧性腦症中樞性衰竭',u'缺氧性腦症中樞性衰竭',u'缺損',u'胸悶',u'脊椎病變',u'脊髓空洞症',u'脊髓損傷',u'退化性脊椎炎',u'退化性脊椎病變',u'退化性頸椎炎',u'馬鞭症候群',u'骨折',u'骨折出血',u'骨折破裂',u'骨刺增生',u'骨斷裂',u'側重擊',u'梗塞',u'淤傷',u'眼外傷性視神經病變',u'第二度燙傷',u'脫臼',u'脫位',u'閉鎖性骨折',u'創傷',u'散狀淤傷',u'椎間盤凸出',u'椎間盤突出',u'椎間盤突出壓迫頸部脊髓',u'椎間盤移位',u'椎間盤脫出',u'無法支撐挺直',u'無法任意轉動',u'無法擺正',u'痛',u'痠疼',u'發炎',u'硬化症',u'硬腦膜上腔出血',u'筋膜炎',u'腔室症候群',u'裂傷',u'鈍力挫傷',u'鈍挫傷',u'鈍傷',u'鈍銼傷',u'開放性骨折',u'開放性傷口',u'傷口',u'傷害',u'損傷',u'暈眩',u'滑脫',u'滑脫症',u'瘀血',u'瘀青',u'瘀傷',u'瘀腫',u'腦部傷害致',u'腦漿溢出',u'腦震盪',u'腫瘤',u'嘔吐',u'截肢',u'緊感',u'酸疼',u'酸痛',u'酸緊',u'僵直',u'僵硬',u'廣泛性軸索損傷',u'撕裂性傷口',u'撕裂傷',u'撕裂擦傷',u'撞擊傷',u'線性骨折',u'線條性挫傷',u'機能障礙',u'燙傷',u'頭痛',u'頸神經病變',u'壓迫性骨折',u'壓傷',u'壓擦傷',u'擦傷',u'濕疹',u'膿傷',u'斷掌',u'斷裂',u'關節病變',u'關節症',u'觸痛']
print 'dic wound set'

def search_wound(wound,content):
    num = 0
    for v in wound:
        if v in content:
            num += 1
            break
#     print 'search_situation - %d'%num
    return 1 if num > 0 else 0

print 'def search_wound(wound,content) set'

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
                                
                total_get += search_wound(wound,content)

                if total_get > 0:
#                     print x,total_get
                    total+= 1
#                 print '-------------'
    return total,len(os.listdir(all_files)),(total+0.0)*100/len(os.listdir(all_files))
print 'def run(pos) set\n'

with codecs.open('search_wound.txt','a','utf-8') as fr:
    for pos in ls:
        fr.write('%s - '%pos)
        print '%s'%pos
        fr.write('find number - %d ; total number - %d ; rate - %0.1f %% \r\n'%run(pos))
        print 'find number - %d ; total number - %d ; rate - %0.1f %%'%run(pos)