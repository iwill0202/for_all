# -*- coding:utf-8 -*-
costs = {u'精神慰撫金':[u'精神慰撫金',u'慰撫金']
,u'維修費':[u'必要修復費',u'必要修復費用',u'維修費',u'維修費用',u'修復費',u'修復費用',u'修理費',u'修理費用',u'零件費',u'零件費用']
,u'醫療費':[u'醫療費',u'醫療費用',u'藥費',u'醫藥費',u'醫藥費用',u'診療費',u'診療費用',u'急診費',u'急診費用',u'特別護士費',u'救護車與特別護士費',u'醫療用品費',u'醫療用品費用',u'腦震盪費用',u'病房費',u'病房費用',u'住院費',u'住院費用',u'住院用品等費用',u'住院用品費用']
,u'後續調養費':[u'療養費',u'療養費用',u'後續調養費',u'後續調養費用',u'後續治療費',u'後續治療費用',u'復健費',u'復健費用',u'義齒重置費',u'義肢費',u'義肢費用']
,u'膳食費':[u'膳食費',u'營養費',u'營養費用']
,u'交通費':[u'車資',u'交通費',u'交通費用',u'計程車費',u'計程車費用',u'救護車費',u'停車費']
,u'看護費':[u'看護費',u'看護費用',u'照護費',u'照護費用']
,u'勞動能力損失':[u'勞動能力減損',u'勞動力減損',u'勞力減損',u'勞動能力損失',u'減少勞動能力',u'受傷期間無法工作']
,u'薪資補償費':[u'每日工資',u'鐘點費',u'薪資補償費',u'工作損失',u'工作薪資損失']
,u'殯葬費':[u'殯葬費',u'殯葬費用',u'埋葬費',u'埋葬費用',u'喪葬費',u'喪葬費用',u'收殮費',u'收殮費用',u'賓葬費',u'賓葬費用']
,u'撫養費':[u'扶養費',u'扶養費用',u'撫養費',u'撫養費用']    
,u'撫恤金':[u'撫卹金',u'撫卹費',u'撫恤金',u'撫慰金']
,u'財產損失':[u'財產損害',u'財產損失',u'財物損失']
,u'生活費用':[u'生活上需要費用',u'生活上需要之費用',u'生活上必要之支出',u'生活雜費',u'生活費用',u'生活費']
,u'拖車費':[u'拖吊費',u'拖吊費用',u'拖車費',u'拖車費用']
,u'剩餘殘值':[u'賸餘殘值',u'剩餘殘值']
       }
print 'dic costs set'

def search_costs(costs,content):
    num = 0
    for v in costs.keys():
        for i in costs[v]:
            if i in content:
                #print x,i
                num += 1
#     print 'search_costs - %d'%num
    return 1 if num > 0 else 0

print 'def search_costs(costs,content) set'


law = {u'原告主張':[u'原告主張',u'原告起訴主張']
      ,u'被告抗辯':[u'被告抗辯',u'被告則以',u'等語為辯',u'被告辯稱',u'被告則辯稱',u'答辯',u'答辯聲明',u'情詞置辯']
      ,u'相關證明':[u'相關證明',u'證明書',u'證明單']
      ,u'道路交通事故調查報告表':[u'道路交通事故調查報告表',u'調查報告表']
      ,u'道路交通事故初步分析表':[u'道路交通事故初步分析研判表',u'道路交通事故初步分析表']
      ,u'鑑定意見書':[u'鑑定意見書',u'車輛行車事故鑑定意見書',u'車輛行車事故鑑定委員會鑑定意見書']
      ,u'交通事故鑑定委員會':[u'交通事故鑑定委員會',u'行車事故鑑定會',u'車輛行車事故鑑定會',u'車輛行車事故鑑定委員會',u'交通局車輛行車事故鑑定委員會',u'交通部公路總局車輛行車事故鑑定會',u'交通事件裁決處',u'交通事件裁決所']
      ,u'行車事故鑑定覆議會':[u'交通部公路總局車輛行車事故鑑定覆議會',u'行車事故鑑定覆議會',u'車輛行車事故鑑定覆議會']
      ,u'有過失':[u'疏於注意',u'疏未注意',u'未注意',u'有過失']
      ,u'無過失':[u'客觀上無從注意防範',u'無故意或過失']
      ,u'過失駕駛':[u'過失駕駛',u'有過失駕駛之行為',u'駕車行為即屬有過失']
        }
print 'dic law set'

def search_law(law,content):
    num = 0
    for v in law.keys():
        for i in law[v]:
            if i in content:
                #print x,i
                num += 1
#     print 'search_law - %d'%num
    return 1 if num > 0 else 0

print 'def search_law(law,content) set'


vechical ={u'腳踏車':[u'腳踏自行車']
,u'三輪車':[u'三輪腳踏車',u'農用三輪車',u'三輪車',u'拼裝動力三輪車',u'拼裝三輪車',u'機器三輪車',u'馬達三輪車',u'摩拖三輪車',u'電動三輪車',u'動力三輪車',u'單速三輪車',u'大型三輪車',u'醫療用電三輪車',u'電動代步車',u'拼裝附動力三輪車',u'殘障三輪車',u'身心障礙者生活輔助器具特製車',u'殘障動力三輪車']
,u'自小客車':[u'自小客',u'自小客車',u'自用小客車']
,u'租賃小客車':[u'租賃小客車',u'租賃用小客車']
,u'輕型機車':[u'機器腳踏車',u'普通輕型機車']
,u'重型機車':[u'重型機車',u'普通重機車',u'普通重型機車']
,u'大客車':[u'遊覽車',u'出租遊覽車',u'大客車',u'營業大客車']
,u'火車':[u'火車',u'電力機車']
,u'拖板車':[u'拖板車',u'電動拖板車']
,u'特種車':[u'油罐車',u'垃圾車',u'灑水車',u'吊車',u'救濟車',u'消防車',u'救護車'u'警備車',u'憲警巡邏車',u'工程車',u'教練車',u'殘障用特製車',u'郵車',u'清掃車',u'水肥車',u'囚車',u'殯儀館運靈車',u'靈車']
,u'大貨車':[u'大貨車']
,u'計程車':[u'計程車']
,u'小巴':[u'小巴',u'吉普車']
,u'貨車':[u'貨車']
,u'農用車':[u'農用車']
,u'大卡車':[u'大卡車',u'貨櫃車']
,u'聯結車':[u'聯結車']
,u'拼裝車':[u'拼裝車']
,u'攤販推車':[u'攤販推車']
,u'非依軌道行駛之動力車輛':[u'非依軌道行駛之動力車輛']
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
    return 1 if num > 0 else 0

print 'def search_vechical(vechical,content) set'


weather = {u'晴':[u'天氣晴',u'天氣晴朗',u'晴朗無雨',u'無雨天氣',u'天氣晴朗且視距良好',u'天氣良好',u'日間天氣晴',u'晨間天氣晴朗',u'無風無雨',u'日間自然光線']
,u'雨':[u'天氣雨',u'天氣均為雨',u'有雨之天氣'u'天氣微雨',u'夜間有雨',u'陰雨',u'下雨不斷']
,u'陰':[u'天氣陰']
,u'高溫':[u'氣溫甚高',u'天氣酷熱',u'天氣炎熱']
,u'霧':[u'天氣起霧',u'夜間雨霧視線不清',u'雨霧',u'濃霧',u'起霧',u'煙霧']
,u'昏暗':[u'天氣昏暗',u'夜間雨霧視線不清',u'天氣陰沉無月光',u'隧道內光線不足',u'夜間有雨',u'夜間無照明',u'天色陰暗',u'能見度低']
,u'強風':[u'強風']
}
print 'dic weather set'

def search_weather(weather,content):
    num = 0
    for v in weather.keys():
        for i in weather[v]:
            if i in content:
                #print x,i
                num += 1
#     print 'search_weather - %d'%num
    return 1 if num > 0 else 0
    
print 'def search_weather(weather,content) set'


situation = {u'無安全車距':[u'未保持行車安全間隔',u'未保持行車安全距離']
,u'未減速':[u'未依法減速慢行',u'未依規定減速',u'未減速慢行',u'未減速',u'肇事時時速']
,u'搶道':[u'爭道行駛',u'搶道行駛']
,u'方向不定':[u'蛇行',u'方向不定']
,u'方向不當':[u'逆向行駛',u'方向不當']
,u'違規轉彎':[u'左轉彎未依規定',u'右轉彎未依規定',u'迴轉未依規定',u'調頭不慎']
,u'行駛時無燈光':[u'未依規定使用燈光',u'未燃亮燈光',u'夜間未開啟燈光',u'燈光系統故障']
,u'使用手機':[u'使用行動電話',u'使用手機',u'撿手機']
,u'裝載違規':[u'貨物超長',u'貨物超寬',u'貨物超高',u'裝載不當',u'裝載貨物不穩',u'超載人員']
,u'違停':[u'違規停車',u'暫停不當',u'禁止臨時停車標線',u'違規臨時停車']
,u'追撞':[u'追撞',u'過失追撞',u'自後追撞',u'從後面追撞']
,u'對向擦撞':[u'對向擦撞']
,u'同向擦撞':[u'同向擦撞',u'擦撞右後照鏡',u'同向通行',u'同向行駛']
,u'違反路權':[u'支道車未讓幹道車先行',u'轉彎車不讓直行車先行',u'未禮讓後方來車先行 ',u'迴轉道左轉未禮讓直行車先行'u'未依規定讓車',u'腳踏車專用道未靠邊通行',u'未靠右行駛']
,u'忽略周圍狀況':[u'未注意車前狀況',u'未注意後方來車']
,u'車況不良':[u'車輪脫落',u'輪鬆脫',u'輪胎爆裂',u'車輛零件脫落',u'違反號誌標線等']
,u'違反號誌':[u'違反特定標線禁制',u'標線禁制',u'不依道路標線違規']
,u'駕駛精神不佳':[u'酒醉駕駛',u'疲勞駕駛',u'酗酒駕駛']
,u'車輛不受控制':[u'催動機車油門往前衝撞',u'啟動機車油門暴衝',u'煞車失靈',u'剎車失靈',u'無法煞停',u'後輪滑胎失控']
,u'行人違規':[u'橫越安全島',u'衝進路中',u'路上嬉戲']
,u'撞公物':[u'撞號誌',u'撞橋樑',u'撞建築物',u'撞路樹',u'撞電桿',u'撞電線桿',u'撞護欄',u'紐澤西護欄',u'行道樹',u'水泥護欄',u'擦撞山壁',u'外側護欄',u'路橋上之門型支撐架']
,u'撞私物':[u'撞動物',u'撞狗',u'撞毀原告所有之圍牆',u'民宅鐵門',u'東南角圍籬',u'購物車',u'前方菜籃']
,u'車身受損':[u'撞保險桿',u'撞葉子板',u'撞車尾門'u'車身鈑金凹陷',u'後車門側緣',u'前葉板',u'保險桿霧燈',u'停放隔壁車位的車',u'處於靜止狀態之車',u'後箱蓋',u'反光燈',u'後照鏡',u'黑色鍍絡保險桿護罩',u'鐵捲門底座護片',u'鋼樑',u'前叉肩蓋與前管之連接處斷裂',u'腳踏車後輪夾煞器變形',u'腳踏車座墊歪斜',u'方向燈',u'檔泥板有擦痕',u'擋風玻璃邊之鋼柱',u'腳踏車前輪',u'腳踏車後輪',u'右側後視鏡',u'左側後視鏡',u'右側前輪處',u'左側前輪處',u'右後鋁圈',u'左後鋁圈',u'左後輪輪框',u'右後輪輪框',u'右後輪輻',u'左後輪輻',u'左前輪弧',u'右前輪弧',u'油箱右側',u'油箱左側',u'撞腳踏車之左手把',u'撞腳踏車之右手把']
,u'視線受阻':[u'影響視線',u'視線受阻']
,u'開啟車門':[u'開啟車門']
,u'號誌狀況不明':[u'號誌狀況不明']
,u'腳踏車違規附載坐人':[u'腳踏車違規附載坐人']
,u'自撞':[u'自撞']
,u'緊急煞車':[u'緊急煞車']
,u'倒車撞':[u'倒車撞']
,u'跨越車道撞擊':[u'跨越車道撞擊']
}
print 'dic situation is set'

def search_situation(situation,content):
    num = 0
    for v in situation.keys():
        for i in situation[v]:
            if i in content:
                #print x,i
                num += 1
#     print 'search_situation - %d'%num
    return 1 if num > 0 else 0

print 'def search_situation(situation,content) set'


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
                # total_get += search_vechical(vechical,content)
                total_get += search_law(law,content)
                # total_get += search_weather(weather,content)
                # total_get += search_situation(situation,content)
                if total_get >0 :
#                     print x,total_get
                    total+= 1
#                 print '-------------'
    return total,len(os.listdir(all_files)),(total+0.0)*100/len(os.listdir(all_files))
print 'def run(pos) set\n'

with codecs.open('search_law.txt','a','utf-8') as fr:
    for pos in ls:
        fr.write('%s - '%pos)
        print '%s'%pos
        fr.write('find number - %d ; total number - %d ; rate - %0.1f %% \r\n'%run(pos))
        print 'find number - %d ; total number - %d ; rate - %0.1f %%'%run(pos)