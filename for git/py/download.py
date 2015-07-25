import requests
from bs4 import BeautifulSoup
uml = 'http://www.thisav.com/video/151502/%E3%81%84%E3%81%84%E3%81%AA%E3%82%8A%E3%83%89m%E8%AA%BF%E6%95%99-%E7%8E%A9%E5%85%B7%E3%81%AB%E3%81%95%E3%82%8C%E3%81%9F%E5%A5%B3%E5%AD%90%E6%A0%A1%E7%94%9F-.html'
res = requests.get(uml)
res.coding = 'utf-8'
soup = BeautifulSoup(res.text)
for x in soup.select('script'):
    if 'so.addVariable' in x.text:
        url =  x.text.split('so.addVariable(\'file\',\'')[1].split('\'')[0]
print 'done'
name = url.split('/')[-1]
import urllib2
download = urllib2.urlopen(url)
output = open(name,'wb')
output.write(download.read())
output.close()
print 'done'