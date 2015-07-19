# -*- coding:utf-8 -*-
import codecs
import os

ls = ['臺北','士林','新北','宜蘭'\
	 ,'基隆','桃園','新竹','苗栗'\
	 ,'臺中','彰化','南投','雲林'\
	 ,'嘉義','臺南','高雄','花蓮'\
	 ,'臺東','屏東','澎湖','金門'\
	 ,'連江']

for i in ls[-6:]:
    location = u'project\%s\\'%i.decode('utf-8')
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        if x[0]!=u'c' and x[0]!=u'W':
            print x
            with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
                l = []
                for line in f:
                    content = line.replace(u'<span  style="color:#e8e8e8">.</span>','')
                    l.append(content)
            with codecs.open('%s%s'%(location,x),'w','utf-8') as f:
                for y in l:
                    f.write(y)
            