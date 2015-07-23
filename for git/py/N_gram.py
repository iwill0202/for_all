# -*- coding: utf-8 -*-


#方法-----show 最後才會做 把所有21個地院的結果輸出
#把word_dic 變成 words_freq -> list 並排序 從 大 到 小 全部!!!
#輸出到資料夾內 叫 Ngram_n_m_xxxxxx
def show(n,dic,total):
    import operator
    word_dic = dic
    words_freq = sorted(word_dic.iteritems(),key=operator.itemgetter(1),reverse=True)
    save = open('project\Ngram_%d.txt'%n,'w')
    save.write('there are %d files were analyzed\n'%total)
    for word in words_freq:#type(word) = list 
        save.write('%s %d\n\n'%(word[0].encode('utf-8'),word[1]))
    save.close()
    print 'function show is done, output a file!!!'
    print 'end!!!!'
print 'function show is set'

#方法-----把資料 用 ngram 塞進 word_dic
#set method ngram(input_data, n)

def ngram(input_data, n):
    for i in range(0,len(input_data)-n+1):
        if input_data[i:i+n] not in word_dic:
            word_dic[input_data[i:i+n]] = 1
        else:
            word_dic[input_data[i:i+n]] += 1
print 'function ngram is set'

#方法-----清理文章
#去除空白 換行...etc    ps 一定要是unicode
def wash(article):
    import re
    content = str(article)
    a = content.strip().replace('　','').replace('<span  style="color:#e8e8e8">.</span>','').decode('utf-8')
    #半形 須加上'\'
    clear = re.sub(u'[\○\%\(\)\s\n,，。、（）／《》】…【「」；：\s, ，\.。:\?？\!！「」 ─┐ ─┘ \[ \] \│ \── \─┼ \┼─ \├─ \├ \├─ \┤ \= \┬┬ \┴┴ \d：【】、；-]','',a)
    return clear
print 'function wash is set'

#方法-----input_where
#把 地點 跟 檔名輸入方法中
def input_where(location,name,n):
    import re
    index_file = open('%scheck_%s'%(location,name),'r')#會讀index檔案
    index_file.readline()#跳過第一行是index的數據

    #讀取第二行 <**non_repeat -7628> 抓最後面的數字 共幾筆 再抓筆數的 幾趴 預設0.3
    number = int(int(index_file.readline().split('-')[1]) * 0.7)
    print number#顯示抓幾筆
    
    for i in range(0,number):#跑筆數
        name = index_file.readline().split('-')[1].strip().decode('utf-8')
        inner_file = open('%s%s'%(location,name),'r')#抓到檔案
        content = inner_file.readline()#過濾掉 第一行
        content = inner_file.readline()#過濾掉 第二行
        clear_article = wash(content)
        ngram(clear_article,n)
    index_file.close()
    return number
print 'function input_where is set'

import time
#N_gram  = ?
for i in range(4,13):
	n = i
	total = 0
	word_dic = {}
	ls = ['台北','士林','新北','宜蘭'\
		 ,'基隆','桃園','新竹','苗栗'\
		 ,'臺中','彰化','南投','雲林'\
		 ,'嘉義','台南','高雄','花蓮'\
		 ,'台東','屏東','澎湖','金門'\
		 ,'連江']
	print '%d begin!!!'%n
	for x in ls:#x = 台北
		place = str(x)
		name = 'Web_%s.txt'%place.decode('utf-8') #Web_台北.txt
		location = 'project\%s\\'%place.decode('utf-8') #project\台北\
		#跑方法
		total = total + input_where(location,name,n)
		print '%s is done!'%place
	#呈現出來 結果
	show(n, word_dic, total)
	print 'N_gram %d is done!!!'%n
	time.sleep(5)
	

