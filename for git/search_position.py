# -*- coding:utf-8 -*-
position = [u'十字韌帶',u'三叉神經根',u'上臂',u'下巴',u'下半身',u'下背部',u'下腿',u'下頰',u'大腳趾骨',u'大腿',u'小指',u'小腿',u'小腿皮膚',u'內踝',u'尺骨',u'手小指',u'手肘',u'手指',u'手腕',u'牙齒',u'肋骨',u'尾胝部',u'尾骨',u'尾椎',u'肝臟',u'足底',u'足部',u'拇指',u'股骨',u'股骨上踝',u'股骨幹',u'股骨頸',u'股骨頸外髁',u'肩胛骨頸部',u'肩峰關節',u'肩部',u'肩鎖骨',u'肱骨',u'近端肱骨',u'枷胸骨',u'玻璃體',u'背部',u'胝骨',u'胝骨及尾骨',u'神經脊柱',u'胸部',u'胸部第十二節',u'胸椎',u'胸腔',u'胸腹部',u'胸壁',u'脊椎',u'脊髓',u'骨盆',u'側肩部',u'側恥骨',u'側恥骨環骨',u'側橈骨末端',u'側頸',u'側頸部',u'側額',u'側額頭',u'眼內',u'眼皮',u'眼角膜',u'眼周區',u'眼眶',u'眼瞼',u'第一掌拇關節處掌面皮膚',u'第三蹠骨',u'脛骨',u'脛骨平台',u'脛腓骨',u'連枷胸',u'掌骨',u'椎弓',u'硬腦膜',u'腓骨',u'腕關節',u'視網膜',u'腦部',u'腦頭皮',u'腰椎',u'腰椎椎弓',u'腹骨盆腔',u'腹部',u'綠內障',u'鼻骨',u'嘴唇',u'膝十字韌帶',u'膝功能關節',u'橈骨',u'頭皮',u'頭骨',u'頭部',u'頭部側臚骨',u'頭部頂部',u'頭部顱內',u'頭頸部',u'頸神經',u'頸神經脊柱',u'頸側',u'頸部',u'頸部下方側鎖骨',u'頸部肌肉韌帶',u'頸部脊椎',u'頸部脊髓',u'頸部退化性頸椎炎',u'頸部動脈',u'頸部經根',u'頸椎',u'頸鎖骨',u'環骨',u'臂',u'薦椎',u'軀幹',u'鎖骨',u'雙手',u'雙臂',u'顏面',u'顏面骨',u'顏面骨骼',u'顏面竇',u'顱內',u'顱骨',u'顳部']
print 'dic position set'

def search_position(position,content):
    num = 0
    for v in position:
        if v in content:
            num += 1
            break
#     print 'search_situation - %d'%num
    return 1 if num > 0 else 0

print 'def search_position(position,content) set'

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
                                
                total_get += search_position(position,content)

                if total_get > 0:
#                     print x,total_get
                    total+= 1
#                 print '-------------'
    return total,len(os.listdir(all_files)),(total+0.0)*100/len(os.listdir(all_files))
print 'def run(pos) set\n'

with codecs.open('search_position.txt','a','utf-8') as fr:
    for pos in ls:
        fr.write('%s - '%pos)
        print '%s'%pos
        fr.write('find number - %d ; total number - %d ; rate - %0.1f %% \r\n'%run(pos))
        print 'find number - %d ; total number - %d ; rate - %0.1f %%'%run(pos)