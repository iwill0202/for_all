# -*- coding: utf-8 -*-
import requests
from bs4 import BeautifulSoup
data = {'__EVENTTARGET':'lnkbtnOhmy1', \
        '__EVENTARGUMENT':'', \
        '__VIEWSTATE':'', \
        '__VIEWSTATEGENERATOR':'', \
        '__EVENTVALIDATION':'', \
        'FDLink':''
       }
#---------------------------------------------------------
#輸入第二層的cookie
cookie='ASP.NET_SessionId=wjpufy555ie5j255z0dzk4nr; lawbank=16d14eb04fc5480b8e601a5d5cd9bbf7-33; y=p=qIy2yccXxgFs%2fJ80vgoeDOw9kLUok4%2f3srjjAB4g1yRTXVVjNR8ynk7shzsPQ%2bTv; _gat=1; _ga=GA1.3.329735530.1434956986; JubFrm-pagebox=%5EcourtFullName%3DKSDV%60%5Ekw%3D%E8%BB%8A%5Ejcatagory%3D2%5Eissimple%3D-1%5Ejt%3D%E6%90%8D%E5%AE%B3%E8%B3%A0%E5%84%9F; x=j=8wMv5HK58tpdIw+zb10V2MgVbtfrvsXl521qvs3jgAOhSQA3PH3ou+p+qpjJpTYxRLwRd9j3mFgw+DYQp2iJcxtxMQ+BnQdaxY3yuieJ961Yh21g1PKmLoICd7goH7PXZJcQlATQrYuD6hg4s1H9DWnhPaC1cgTIXKPFp9jNv96uDoZ0O9Ydzr8BrV8t+v1aKTE43pvb1TQFifpArgUdjGTh6YSxaueUKvmNsLa1cJv/3xnaKcNrthr22VQnrN+n6698zWOOYTn5+gSAjqcP09MRr73sEcXIeQLkZLJcLo9KC1VYMX1ycTPmnDl2JX8W'

#---------------------------------------------------------
import string
if cookie.find('y=p=') != -1:
    pos_yp = cookie.split('y=p=')
    cookie = pos_yp[0]+string.join(pos_yp[1].split(';')[1:],';')

headers = {'Cookie': cookie}
res = requests.get('http://fyjud.lawbank.com.tw/listcontent5.aspx',\
                  headers = headers)
soup = BeautifulSoup(res.text)
#print 'ok'

#catch total_pages----4  and       this_page----now 共70筆第1/4頁
this_page = soup.select('.page > tr > td')[0].text.replace(' ','')
pos_start = this_page.find('/')
pos_end = this_page.find(u'頁')
total_pages = int(this_page[pos_start+1:pos_end])

#catch ----- place
for h4 in soup.select('h4'):
    allname = str(h4).decode('utf-8')
    pos = allname.find('地方法院'.decode('utf-8'))
    place = allname[pos-2:pos].encode('utf-8')
#print 'ok'

#save the first page
#catch ----- all_name    1-新北_104_重簡_526.txt
save_in='project\Web_%s.txt'%place
fid = open(save_in.decode('utf-8'),'w')
for tr in soup.select('.Table-List > tbody > tr')[1:]:
    number = tr.select('td')[0].text.encode('utf-8').replace('.','-')
    #print number
    name = tr.select('td > a')[0].text.encode('utf-8').replace(',','_')
    #print name
    all_name = '%s%s_%s.txt'%(number.replace('.','-'),place,name.replace(',','_'))
    fid.write(all_name+'\n')
fid.close()
print 'the first page is done!!!'

for i in range(1,total_pages):
    data['__VIEWSTATE'] = soup.select('#__VIEWSTATE')[0]['value']
    data['__EVENTVALIDATION'] = soup.select('#__EVENTVALIDATION')[0]['value']
    data['__VIEWSTATEGENERATOR'] = soup.select('#__VIEWSTATEGENERATOR')[0]['value']

    res_post = requests.post('http://fyjud.lawbank.com.tw/listcontent5.aspx',\
                           headers = headers,\
                           data = data)
    soup = BeautifulSoup(res_post.text)
    
    fid = open(save_in.decode('utf-8'),'a')
    for tr in soup.select('.Table-List > tbody > tr')[1:]:
        number = tr.select('td')[0].text.encode('utf-8').replace('.','-')
        #print number
        name = tr.select('td > a')[0].text.encode('utf-8').replace(',','_')
        #print name
        all_name = '%s%s_%s.txt'%(number.replace('.','-'),place,name.replace(',','_'))
        fid.write(all_name+'\n')
    fid.close()
    print 'ok',soup.select('.page > tr > td')[0].text.replace(' ','')