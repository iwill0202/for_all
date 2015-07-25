# -*- coding:utf-8 -*-
'''
for isolation useless virdict
'''
not_choose_in = [u'汽車旅館',u'車位',u'停車位',u'停車空間',u'停車場',u'試車',u'天車',u'吊車',u'吊車費用',u'汽車出賣人',u'公然侮辱',u'公然侮辱強制',u'強制罪',u'恐嚇',u'誹謗',u'離婚',u'貪污治罪條例',u'上訴人',u'剩餘財產分配',u'賸餘財產分配',u'專利',u'專利年費',u'運費',u'清潔費',u'燃料費',u'電費',u'電話費',u'風車台',u'風車臺',u'室內設計',u'建築設計費',u'設計費',u'室內裝潢',u'裝潢費',u'砸毀',u'車馬費',u'交際餐飲費',u'清運費',u'詐欺',u'詐騙集團',u'車手',u'停車費',u'盜領',u'現金卡',u'存款債權',u'汽車貸款',u'車料',u'假資料',u'汽車扣件',u'車縫線',u'強制性交',u'性侵',u'襲胸',u'強吻',u'漏失水',u'保育費',u'管銷費',u'贍養費',u'土地使用糾紛',u'海商法',u'刺殺',u'信用受損害',u'物之瑕疵擔保',u'承攬運送人',u'合夥',u'醫療事故',u'車心軸',u'買賣契約',u'交通船',u'船舶',u'火災',u'鐵捲門瞬間掉下',u'鐵捲門突然下降']
ls = [u'臺北',u'士林',u'新北',u'宜蘭'\
     ,u'基隆',u'桃園',u'新竹',u'苗栗'\
     ,u'臺中',u'彰化',u'南投',u'雲林'\
     ,u'嘉義',u'臺南',u'高雄',u'花蓮'\
     ,u'臺東',u'屏東',u'澎湖',u'金門'\
     ,u'連江']
import os
import codecs

def isolation(pos,not_choose_in):
    try :
        place = pos
        location = u'project\\%s\\'%place
        all_files = os.path.abspath(location)
        for x in os.listdir(all_files):
            if x[0]!=u'c' and x[0]!=u'W':
    #             print x
                with codecs.open(os.path.join(location,x),'r','utf-8') as f:
                    content = f.read()
                for nci in not_choose_in:
                    if nci in content:
                        os.rename(os.path.join(u"C:\\Users\\BigData\\Desktop\\python\\",location,x),
                                 os.path.join(u'C:\\Users\\BigData\\Desktop\\python\\project\\isolation',x))
                        print x,nci
                        break
                        
    except Exception as e :
        print e
                

print 'def isolation(pos) set'

for i in ls:
    isolation(i,not_choose_in)