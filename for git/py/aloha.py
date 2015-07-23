# -*- coding: utf-8 -*-
'''
for check index file
and output 3 things
    non_repeat={}
    repeat={}
    non_files={}
'''
import os
#check index file
ls = ['臺北','士林','新北','宜蘭'\
	 ,'基隆','桃園','新竹','苗栗'\
	 ,'臺中','彰化','南投','雲林'\
	 ,'嘉義','臺南','高雄','花蓮'\
	 ,'臺東','屏東','澎湖','金門'\
	 ,'連江']
print 'ok'

# -*- coding: utf-8 -*-
import os.path
import codecs
def check(pos):
    place = str(pos)
    location = 'project\%s\\'%place.decode('utf-8') #project\台北\
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
            content = f.read().replace(u'　',u'').replace(u' ',u'')
        if content.find(u'法官') == -1 and content.find(u'書記官')==-1:
            if x[0]!=u'c' and x[0]!=u'W':
                print  x.encode('utf-8')

for i in ls:
    check(i)