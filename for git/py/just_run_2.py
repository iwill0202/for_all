# -*- coding:utf-8 -*-
costs = {
u'精神慰撫金':[u'精神慰撫金',u'慰撫金'],
u'維修費':[u'必要修復費',u'修車費',u'修繕費用',u'機車修繕費',u'必要修復費用',u'維修費',u'維修費用',u'修復費',u'修復費用',u'修理費',u'修理費用',u'零件費',u'零件費用'],
u'醫療費':[u'醫療費',u'醫療費用',u'藥費',u'醫藥費',u'醫藥費用',u'診療費',u'診療費用',u'急診費',u'急診費用',u'特別護士費',u'救護車與特別護士費',u'醫療用品費',u'醫療用品費用',u'腦震盪費用',u'病房費',u'病房費用',u'住院費',u'住院費用',u'住院用品等費用',u'住院用品費用',u'自費部份'],
u'後續調養費':[u'療養費',u'療養費用',u'後續調養費',u'後續調養費用',u'後續治療費',u'後續治療費用',u'復健費',u'復健費用',u'義齒重置費',u'義肢費',u'義肢費用'],
u'膳食費':[u'膳食費',u'營養費',u'營養費用'],
u'交通費':[u'救護車接運費',u'車資',u'交通費',u'交通費用',u'計程車費',u'計程車費用',u'救護車費',u'停車費'],
u'看護費':[u'看護費',u'看護費用',u'照護費',u'照護費用'],
u'勞動能力損失':[u'勞動能力減損',u'勞動力減損',u'勞力減損',u'勞動能力損失',u'減少勞動能力',u'受傷期間無法工作'],
u'薪資補償費':[u'每日工資',u'鐘點費',u'薪資補償費',u'工作損失',u'工作薪資損失'],
u'殯葬費':[u'殯葬費',u'殯葬費用',u'埋葬費',u'埋葬費用',u'喪葬費',u'喪葬費用',u'收殮費',u'收殮費用',u'賓葬費',u'賓葬費用'],
u'撫養費':[u'扶養費',u'扶養費用',u'撫養費',u'撫養費用'],
u'撫恤金':[u'撫卹金',u'撫卹費',u'撫恤金',u'撫慰金'],
u'財產損失':[u'財產損害',u'財產損失',u'財物損失'],
u'生活費用':[u'生活上需要費用',u'生活上需要之費用',u'生活上必要之支出',u'生活雜費',u'生活費用',u'生活費'],
u'拖車費':[u'拖吊費',u'拖吊費用',u'拖車費',u'拖車費用'],
u'剩餘殘值':[u'賸餘殘值',u'剩餘殘值']
}

def find_costs(content):
    result = ''
    for i in costs.keys():
        find = ''
        for c in costs[i]:
            if c in content:
                find = '1,'
                break
        if find=='' :
            result = result + '0,'
        else:
            result = result + find
    return result[:-1]

print 'def find_costs(content) set'

vechical = {
u'腳踏車':[u'腳踏自行車'],
u'三輪車':[u'三輪腳踏車',u'農用三輪車',u'三輪車',u'拼裝動力三輪車',u'拼裝三輪車',u'機器三輪車',u'馬達三輪車',u'摩拖三輪車',u'電動三輪車',u'動力三輪車',u'單速三輪車',u'大型三輪車',u'醫療用電三輪車',u'電動代步車',u'拼裝附動力三輪車',u'殘障三輪車',u'身心障礙者生活輔助器具特製車',u'殘障動力三輪車'],
u'小客車':[u'不明車號汽車',u'不明車輛',u'不明汽車',u'自小客',u'自小客車',u'自用小客車',u'租賃小客車',u'租賃用小客車',u'休旅車'],
u'營業小客車':[u'計程車',u'營業小客車',u'營業用小客車'],
u'輕型機車':[u'機器腳踏車',u'普通輕型機車',u'電動機車'],
u'重型機車':[u'警用重型機車',u'重型機車',u'普通重機車',u'普通重型機車',u'電動重型機車'],
u'大客車':[u'遊覽車',u'出租遊覽車',u'大客車',u'營業大客車',u'公車',u'客運'],
u'農用車':[u'農耕機',u'農耕曳引機',u'農耕曳引車',u'農耕用車'],
u'火車':[u'火車',u'電力機車'],
u'卡車':[u'曳引車',u'全拖車',u'貨櫃車',u'聯結車',u'大卡車',u'貨車'],
u'拖板車':[u'拖板車',u'電動拖板車']
}
crash_type = {
u'對撞':[u'對撞'],
u'推撞':[u'推撞'],
u'倒車撞':[u'倒車撞'],
u'追撞':[u'追撞',u'過失追撞',u'自後追撞',u'從後面追撞',u'後車尾發生擦撞'],
u'擦撞':[u'同向擦撞',u'擦撞右後照鏡',u'擦撞左後照鏡',u'對向擦撞',u'前車頭發生擦撞'],
u'側撞':[u'側撞',u'攔腰撞擊']
}
def find_crash_type(content):
    result = ''
    for i in crash_type.keys():
        find = ''
        for c in crash_type[i]:
            if c in content:
                find = '1,'
                break
        if find=='' :
            result = result + '0,'
        else:
            result = result + find
    return result[:-1]

print 'def find_crash_type(content) set'

situation = {
u'無安全車距':[u'未保持行車安全間隔',u'未保持行車安全距離'],
u'未減速':[u'未依法減速慢行',u'未依規定減速',u'未減速慢行',u'未減速',u'肇事時時速'],
u'搶道':[u'爭道行駛',u'搶道行駛'],
u'未配戴安全帽':[u'未配戴安全帽'],
u'方向不定':[u'蛇行',u'方向不定'],
u'開啟車門':[u'開啟車門'],
u'腳踏車違規附載坐人':[u'腳踏車違規附載坐人'],
u'緊急剎車':[u'緊急剎車',u'緊急煞車'],
u'方向不當':[u'逆向行駛',u'方向不當'],
u'違規轉彎':[u'左轉彎未依規定',u'右轉彎未依規定',u'迴轉未依規定',u'調頭不慎'],
u'使用手機':[u'使用行動電話',u'使用手機',u'撿手機'],
u'裝載違規':[u'貨物超長',u'貨物超寬',u'貨物超高',u'裝載不當',u'裝載貨物不穩',u'超載人員'],
u'行駛時不開燈':[u'未依規定使用燈光',u'未燃亮燈光',u'夜間未開啟燈光'],
u'通過平交道':[u'越過平交道',u'搶越平交道',u'闖越平交道'],
u'違停':[u'違規停車',u'暫停不當',u'禁止臨時停車標線',u'違規臨時停車'],
u'違反路權':[u'支道車未讓幹道車先行',u'轉彎車不讓直行車先行',u'未禮讓後方來車先行',u'迴轉道左轉未禮讓直行車先行',u'未依規定讓車',u'腳踏車專用道未靠邊通行',u'未靠右行駛'],
u'忽略周圍狀況':[u'未注意車前狀況',u'未注意後方來車',u'橫越道路不慎',u'倒車未依規定',u'閃避不及'],
u'車況不良':[u'車輪脫落',u'輪鬆脫',u'輪胎爆裂',u'車輛零件脫落',u'燈光系統故障',u'未設置反光鏡',u'熄火',u'電源用盡'],
u'違反號誌標線等':[u'違反號誌',u'違反特定標線禁制',u'標線禁制',u'不依道路標線違規',u'穿越雙黃線',u'跨越雙白實線'],
u'駕駛精神不佳':[u'酒醉失控撞擊',u'酒醉駕駛',u'疲勞駕駛',u'酗酒駕駛'],
u'車輛不受控制':[u'催動機車油門往前衝撞',u'啟動機車油門暴衝',u'煞車失靈',u'剎車失靈',u'無法煞停',u'後輪滑胎失控',u'誤踩油門自後追撞前車',u'避難措施而剎車後仍遭撞擊',u'催動油門',u'催動機車油門',u'催加機車油門',u'啟動機車油門',u'控制機車油門',u'衝出路外'],
u'行人違規':[u'橫越安全島',u'衝進路中',u'路上嬉戲'],
u'車身受損':[u'撞保險桿',u'撞葉子板',u'撞車尾門',u'車身鈑金凹陷',u'後車門側緣',u'前葉板',u'保險桿霧燈',u'停放隔壁車位的車',u'處於靜止狀態之車',u'後箱蓋',u'反光燈',u'後照鏡',u'黑色鍍絡保險桿護罩',u'鐵捲門底座護片',u'鋼樑',u'前叉肩蓋與前管之連接處斷裂',u'腳踏車後輪夾煞器變形',u'腳踏車座墊歪斜',u'方向燈',u'檔泥板有擦痕',u'擋風玻璃邊之鋼柱',u'腳踏車前輪',u'腳踏車後輪',u'右側後視鏡',u'左側後視鏡',u'右側前輪處',u'左側前輪處',u'右後鋁圈',u'左後鋁圈',u'左後輪輪框',u'右後輪輪框',u'右後輪輻',u'左後輪輻',u'左前輪弧',u'右前輪弧',u'油箱右側',u'油箱左側',u'撞腳踏車之左手把',u'撞腳踏車之右手把'],
u'視線受阻':[u'影響視線',u'視線受阻']
}


def find_situation(content):
    result = ''
    for i in situation.keys():
        find = ''
        for c in situation[i]:
            if c in content:
                find = '1,'
                break
        if find=='' :
            result = result + '0,'
        else:
            result = result + find
    return result[:-1]

print 'def find_situation(content) set'



time = {
u'夜間':[u'凌晨',u'晚間',u'零時',u'晚上',u'半夜',u'夜半',u'夜晚',u'零晨',u'午夜',u'淩晨',u'深夜',u'晚11時',u'晚8時',u'晚6時',u'晚7時',u'晚二十一時',u'晚九時',u'晚十一時',u'晚六時',u'晚22時',u'晚9時',u'晚10時',u'夜晚0時'],
u'日間':[u'上午',u'下午',u'中午',u'早上',u'傍晚',u'早晨',u'清晨',u'晨五時',u'晨5時',u'晨間',u'午間',u'午四時',u'午4時',u'午22時',u'午二十二時',u'近午時間',u'正午',u'上許',u'上9時',u'上九時',u'上五8時',u'白天',u'日間']
}

def find_time(content):
    result = ''
    for i in time.keys():
        find = ''
        for c in time[i]:
            if c in content:
                find = '1,'
                break
        if find=='' :
            result = result + '0,'
        else:
            result = result + find
    return result[:-1]

print 'def find_time(content) set'


weather = {
u'晴':[u'天氣晴',u'天氣晴朗',u'晴朗無雨',u'無雨天氣',u'天氣晴朗且視距良好',u'天氣良好',u'日間天氣晴',u'晨間天氣晴朗',u'無風無雨',u'日間自然光線'],
u'雨':[u'天氣雨',u'天氣均為雨',u'有雨之天氣'u'天氣微雨',u'夜間有雨',u'陰雨',u'下雨不斷'],
u'陰':[u'天氣陰'],  
u'高溫':[u'氣溫甚高',u'天氣酷熱',u'天氣炎熱'],
u'霧':[u'天氣起霧',u'夜間雨霧視線不清',u'雨霧',u'濃霧',u'起霧',u'煙霧'],
u'昏暗':[u'天氣昏暗',u'夜間雨霧視線不清',u'天氣陰沉無月光',u'隧道內光線不足',u'夜間有雨',u'夜間無照明',u'天色陰暗',u'能見度低']
}

def find_weather(content):
    result = ''
    for i in weather.keys():
        find = ''
        for c in weather[i]:
            if c in content:
                find = '1,'
                break
        if find=='' :
            result = result + '0,'
        else:
            result = result + find
    return result[:-1]

print 'def find_weather(content) set'

def find_vehicals(ls):
    Plaintiffs_vechical = []
    Defendants_vechical = []
    for i in range(len(ls)):#------------------------1st for
                                #ls[i]
        for v in vechical.keys():#------------------2nd for
            for c in vechical[v]:#------------------3rd for
                if c in ls[i]:
                    if u'原告' not in ls[i] and u'被告' not in ls[i]:#若是兩個都沒有往前早
                        for minus in range(1,3):
                            if u'原告' in ls[i-minus] and u'被告' in ls[i-minus]:
                                if ls[i-minus].find(u'原告')< ls[i-minus].find(u'被告'):
                                    Defendants_vechical.append(v)
                                    break
                                
                                else:
                                    Plaintiffs_vechical.append(v)
                                    break
                            
                            elif u'原告' in ls[i-minus]:
                                Plaintiffs_vechical.append(v)
                                break
                            
                            elif u'被告' in ls[i-minus]:
                                Defendants_vechical.append(v)
                                break
                                
                    elif u'原告' in ls[i] and u'被告' in ls[i]:
                        if ls[i].find(u'被告') < ls[i].find(u'原告') < ls[i].find(c):
                            Plaintiffs_vechical.append(v)
                            continue
                        
                        else:
                            Defendants_vechical.append(v)
                            continue
            
                    elif u'原告' in ls[i]:
                        Plaintiffs_vechical.append(v)
                        continue

                    elif u'被告' in ls[i]:
                        Defendants_vechical.append(v)
                        continue
     
    Plaintiffs_vechical = list(set(Plaintiffs_vechical))
    Defendants_vechical = list(set(Defendants_vechical))
    plv = '_'.join(Plaintiffs_vechical) if len(Plaintiffs_vechical) != 0 else 0
    dev = '_'.join(Defendants_vechical) if len(Defendants_vechical) != 0 else 0
    return '%s,%s'%(plv,dev)
print 'def find_vehicals(content) set'


import os
import codecs
import re
result_name = 'for_cluster_pos.txt'
try:
    os.remove(result_name)
except:
    pass
dic={}
#['我方','對方','事故原因','撞擊模式','天氣和時間','肇事路段','傷亡情況','法院地點']
def data_output(dic,pos):
    no = 0
    location = u'project\\%s\\'%pos
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        with codecs.open(os.path.join(location,x),'r','utf-8') as f:
            no+=1
            print no,x
            content = f.read().replace(u' ',u'').replace(u'　',u'')\
                              .replace(u'\r',u'').replace(u'\n',u'')
        
        cut = content.find(u'事實') if u'事實' in content else content.find(u'理由')
        short = content[cut:]
        delimiter = "，|。|、".decode('utf-8')
        ls = re.split(delimiter, short)[:30]
        result_v = find_vehicals(ls)

        result = '%s_%s_%s_%s_%s_%s'%(find_costs(content)
        ,find_crash_type(content)
        ,find_situation(content)
        ,find_time(content)
        ,find_weather(content)
        ,result_v)

        if result in dic:
            dic[result] +=1
        else:
            dic[result]=1
        
        
ls = [u'臺北',u'士林',u'新北',u'宜蘭'\
     ,u'基隆',u'桃園',u'新竹',u'苗栗'\
     ,u'臺中',u'彰化',u'南投',u'雲林'\
     ,u'嘉義',u'臺南',u'高雄',u'花蓮'\
     ,u'臺東',u'屏東',u'澎湖',u'金門'\
     ,u'連江']

for pos in ls:
    print pos
    data_output(dic,pos)
    
with codecs.open(result_name,'w','utf-8') as f:
    for k in sorted(dic, key=dic.get, reverse=True):
        f.write('%s\t%s\r\n'%(dic[k],k))
#         print dic[k],k
print 'finish!!!!'