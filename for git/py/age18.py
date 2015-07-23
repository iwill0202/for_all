import requests
res = requests.get('http://www.thisav.com/videos')
print res.text
print res.status_code 
print res.headers['content-type']