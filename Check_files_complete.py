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


# -*- coding:uft-8 -*-
import os.path
import codecs

def check_both(pos):
    neither=[]
    place = str(pos)
    location = 'project\%s\\'%place.decode('utf-8') #project\台北\
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
            content = f.read().replace(u'　',u'').replace(u' ',u'')
        if content.find(u'法官') == -1 and content.find(u'書記官')==-1:
            if x[0]!=u'c' and x[0]!=u'W':
                neither.append(x)
    return neither
                
def check_write(pos):
    no_write=[]
    place = str(pos)
    location = 'project\%s\\'%place.decode('utf-8') #project\台北\
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
            content = f.read().replace(u'　',u'').replace(u' ',u'')
        if content.find(u'書記官')==-1:
            if x[0]!=u'c' and x[0]!=u'W':
                no_write.append(x)
    return no_write
                
def check_law(pos):
    no_law=[]
    place = str(pos)
    location = 'project\%s\\'%place.decode('utf-8') #project\台北\
    all_files = os.path.abspath(location)
    for x in os.listdir(all_files):
        with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
            content = f.read().replace(u'　',u'').replace(u' ',u'')
        if content.find(u'法官') == -1:
            if x[0]!=u'c' and x[0]!=u'W':
                no_law.append(x)
    return no_law
	
	
neither = []
no_write = []
no_law = []
for a in ls:
    for x in check_both(a):
        neither.append(x)
    print len(neither)
	
    for x in check_write(a):
        no_write.append(x)
    print len(no_write)
	
    for x in check_law(a):
        no_law.append(x)
    print len(no_law)
	
with open(u'兩個都沒有.txt','w') as f:
    f.write('兩個都沒有數目 - %d\n'%len(neither))
    num = 1
    for x in neither:
        f.write('%d - %s\n'%(num,x.encode('utf-8')))
        num+=1
print 'both is done'

#------------------------------------------------------------------------
with open(u'沒書記官.txt','w') as f:
    f.write('沒書記官數目 - %d\n'%len(no_write))
    num = 1
    for x in no_write:
        f.write('%d - %s\n'%(num,x.encode('utf-8')))
        num+=1
print 'no write is done'

#------------------------------------------------------------------------
with open(u'沒法官.txt','w') as f:
    f.write('沒法官數目 - %d\n'%len(no_law))
    num = 1
    for x in no_law:
        f.write('%d - %s\n'%(num,x.encode('utf-8')))
        num+=1
print 'no law is done'