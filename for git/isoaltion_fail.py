# -*- coding:utf-8 -*-
import os
import codecs
find = [u'車禍',u'交通事故']
num = 0
location = u'C:\\Users\\BigData\\Desktop\\python\\project\\isolation'
all_files = os.path.abspath(location)
for x in os.listdir(all_files):
    with codecs.open(os.path.join(location,x),'r','utf-8')as f:
        content = f.read()
        for i in find:
            if i in content:
                with codecs.open('isolation fail.txt','a','utf-8') as fi:
                    num +=1
                    print num
                    fi.write('(%d) - %s\r\n'%(num,x))
                    break