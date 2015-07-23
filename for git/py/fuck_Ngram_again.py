# -*- coding:utf-8 -*-
import re
import os
import codecs
def ngram(pos,word_dic,n,useless):
    place = str(pos)
    location = u'project\%s\\'%place.decode('utf-8')
    all_files = os.path.abspath(location)
    total_files = 0
    
    find_ls = [u'被告抗辯',u'被告則以',u'被告辯稱',u'被告之答辯',\
      u'被告則辯稱',u'答辯',u'答辯聲明',u'情詞置辯']
    
    find = [u'事實及理由',u'事實']
    
    for x in os.listdir(all_files):
        if x[0]!='W' and x[0]!='c':# removed Web_xxx.txt and check_xxx.txt
            total_files +=1
            print x
            with codecs.open('%s%s'%(location,x),'r','utf-8') as f:
                a = f.read().strip().replace(u'　','')\
                            .replace(u' ','')\
                            .replace(u'<span  style="color:#e8e8e8">.</span>','')
                content = re.sub(u'[\○\%\(\)\s\n,，。％、（）／《》】…【「」；：\s, ，\.。:\?？\!！「」 ─┐ ─┘ \[ \] \│ \── \─┼ \┼─ \├─ \├ \├─ \┤ \= \┬┬ \┴┴ \d：【】、；-]','',a)
                
                for i in find:
                    if content.find(i)!=-1:
                        begin = content.find(i)
                        break
                    
                for i in find_ls:
                    if content.find(i)!=-1:
                        end = content.find(i)
                        break
            
			content = content[begin:end] if end>0 else content[begin:]
            for i in useless:
                if content.find(i)!=-1:
                    content = content.replace(i,'')
            #start for N-gram
            for i in range(0,len(content)-n+1):
                if content[i:i+n] not in word_dic:
                    word_dic[content[i:i+n]] = 1
                else:
                    word_dic[content[i:i+n]] += 1
                    #print content[i:i+n],word_dic[content[i:i+n]]
    #print total_files
    return total_files
print 'function ngram is ok'

def output(word_dic,total,n):
    import operator
    num = 0
    total_files = total
    upper = int(total_files*1.3)
    lower = int(total_files*0.7)
    
    save_name = 'Ngram %d.txt'%n
    with open(save_name,'w')as f:
        f.write('Total files - %d\n'%total)
        for x in word_dic:
            if word_dic[x]>= lower and word_dic[x]<= upper:
                num+=1
                f.write('(%d) - %s - %d\n'%(num,x.encode('utf-8'),word_dic[x]))
    print 'ok'
print 'function output is ok'

print 'Let\'s start!'
n=7
word_dic={}  #for seperate's words
total = 0
ls = ['臺北','士林','新北','宜蘭'\
	 ,'基隆','桃園','新竹','苗栗'\
	 ,'臺中','彰化','南投','雲林'\
	 ,'嘉義','臺南','高雄','花蓮'\
	 ,'臺東','屏東','澎湖','金門'\
	 ,'連江']

print 'Let\'s ROCK!!!'

useless = []
import codecs
with codecs.open('useless.txt','r','utf-8') as f:
    for x in f:
        useless.append(x.strip())
print 'list useless is ok'

# total = ngram('金門',word_dic,n,useless)
for x in ls[0:3]:
    print x.decode('utf-8'),'start'
    total += ngram(x,word_dic,n,useless)
print total
output(word_dic,total,n)
print 'fucking %d has done'%n

