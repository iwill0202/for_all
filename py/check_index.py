# -*- coding: utf-8 -*-

import os
#check index file
ls = ['台北','士林','新北','宜蘭'\
	 ,'基隆','桃園','新竹','苗栗'\
	 ,'臺中','彰化','南投','雲林'\
	 ,'嘉義','台南','高雄','花蓮'\
	 ,'台東','屏東','澎湖','金門'\
	 ,'連江']


def check(pos):
	place = str(pos)
	name = 'Web_%s.txt'%place.decode('utf-8') #Web_台北.txt
	location = 'project\%s\\'%place.decode('utf-8') #project\台北\
	open_index = open('%s%s'%(location,name),'r') #project\台北\Web_台北.txt

	non_repeat = {}
	repeat = {}
	non_files = {}

	total = 0
	nr_num = 0  #non_repeat number
	r_num = 0  #repeat number
	nf_num = 0  #no_file number
	blank = ''

	#每一行去跟下一行比較
	for line in open_index:
		total+=1
		split = line.split('-')
		#print split[0],split[1]
		if blank==split[1]:
			repeat[total] = line
			r_num += 1
		else:
			if os.path.isfile('%s%s'%(location,split[1].strip().decode('utf-8'))):
				#there 's non repeat and the file do exist
				non_repeat[total] = line
				nr_num += 1
			else:
				#there 's non repeat ,but the file do NOT exist
				non_files[total] = line
				nf_num += 1
			blank = split[1]
			
		
	open_index.close()
	print 'total =',total,'; nr_num + r_num + nf_num =',nr_num+r_num+nf_num
	print
	print 'non_repeat =',nr_num,'; repeat =',r_num,'; no_file =',nf_num

	#sort repeat{}
	ls_repeat=[]
	for i in repeat:
		ls_repeat.append(i)
	ls_repeat.sort()

	#sort non_files{}
	ls_non_files=[]
	for i in non_files:
		ls_non_files.append(i)
	ls_non_files.sort()


	#write into a file ----- check_+name
	fr = open('%scheck_%s'%(location,name),'w')
	fr.write('non_repeat = %d ; repeat = %d ; no_file = %d\n'%(nr_num,r_num,nf_num))

	#write non_repeat
	fr.write('**non_repeat -%d\n'%nr_num)
	for i in non_repeat :
		fr.write(non_repeat[i])
	fr.write('\n------------------------------------------\n')

	#write repeat
	fr.write('**repeat -%d\n'%r_num)
	for i in ls_repeat:
		fr.write(repeat[i])
	fr.write('\n------------------------------------------\n')

	#write non_files
	fr.write('**non_files -%d\n'%nf_num)
	for i in ls_non_files:
		fr.write(non_files[i])

	fr.close()

	print pos,'ok'

for i in ls:
	check(i)
