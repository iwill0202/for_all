package com.iii.schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test {
	private static List<String>classNames;
	
	private static void getClass(int year,int month,String date)throws Exception{
		URL url = new URL("http://140.115.236.11/NEXT2.ASP?YY="+year+"&MM="+month+"&Query_item=%AFZ%AF%C5&NEXT=%A4U%A4%40%A8B"); 
		Document xmlDoc =  Jsoup.parse(url, 4000); 
		Elements option = xmlDoc.select("option");
				
		classNames= new ArrayList<String>();
		
		for(int i=0;i<option.size();i++){
//			System.out.println(date+option.get(i).text());
			classNames.add(String.format("%d_%d_%s", year,month,option.get(i).text()));
		}
		//2015_05_ZZ101
	}//end of getClass()
			
	private static void CompareClassNames(List<String>list,String date)throws Exception{
		//eg. list==2015_05_ZZ101
		for(int i=0;i<list.size();i++){
			String dataName=String.format("%s.csv",list.get(i));
			//System.out.println(dataName);
			File file = new File("res\\"+dataName);
			if(file.exists()){
				continue;
			}else{
				//System.out.println(i+"-none");
				File fileOut = new File("res\\"+dataName);
				PrintWriter out  = new PrintWriter(new FileWriter(fileOut,false));
				out.println();
				out.close();
				//System.out.println("create-"+dataName);
			}
		}
	}//end of CompareClass()
			
	private static void getCourse(List<String>classNames,int year,int month,String date)throws Exception{
		//List<String>list = null;
		//System.out.println(classNames.get(0));
		for(int i=0;i<classNames.size();i++){
			String[] onlyclass = classNames.get(i).split("_");
			URL url = new URL("http://140.115.236.11/query_tea.asp?STR="+onlyclass[2]+"&Query=%ACd%B8%DF&MM2="+month+"&YY2="+year+"&item2=%AFZ%AF%C5"); 
			Document xmlDoc = Jsoup.parse(url, 3000); 
			Elements td = xmlDoc.select("td");  
			
			List<String>list = new ArrayList<String>();
			/**把表格重製，從第一週開始 第11個td*/
				
			int beginTd=12;//起始的td
			 /*int timeContent=1;
			tdNo = beginTd*b+c+8*a
			a=0,1,2		影響上午、下午、夜間
			b=1,3,5,7,9	影響週數
			c=0,1,2,3,4	影響週數
			int a=0;
			*/
			//String split = ",";
			int b=1;
			for(int c=0;c<5;c++){//b c 週數
				for(int a=0;a<3;a++){//a  上午-0、下午-1、夜間-2
					int tdNo=beginTd*b+c+8*a;
					for(int timeContent=1;timeContent<8;timeContent++){
						int period = tdNo+timeContent;
						String dates = td.get(period).getElementsByTag("font").text();
						String course = td.get(period).getElementsByTag("u").text();
						String classroom = td.get(period).getElementsByTag("b").text();
						String coma = ",";
						td.get(period).select("font").remove();
						td.get(period).select("u").remove();
						td.get(period).select("b").remove();
						String teacher = td.get(period).text().replaceAll("　","").trim();
						list.add(dates+coma+teacher+coma+course+coma+classroom);

					}
				}//end of for int a
				b+=2;
			}//end of for int c
			
			/**製成 final csv
			 大於小於 是為了取得每一週的上午下午夜間的間隔
			 一個月以五週來說
			 所以 if 裡面總共會有 五個大於小於 中間以 or 連接
			 目前大於小於是硬砍砍出來的 看有沒有人有更好的想法來寫
			 */
				
			String morning="上午";
			String afternoon="下午";
			String night="夜間";
			String split=",";
			//StringBuffer sb = new StringBuffer(1000);
			List<String>course = new ArrayList<String>();
			for(int j=0;j<list.size();j++){
				//上午
				if((j>=0&&j<=6) ||(j>=21&&j<=27)||(j>=42&&j<=48)||(j>=63&&j<=69)||(j>=84&&j<=90)){
					course.add(j+"-"+morning+split+list.get(j));
				}
				//下午
				else if((j>=7&&j<=13) ||(j>=28&&j<=34)||(j>=49&&j<=55)||(j>=70&&j<=76)||(j>=91&&j<=97)){
					String[] tokens = list.get(j-7).split(",");//catch date					
					course.add(j+"-"+afternoon+split+tokens[0]+list.get(j));
				}
				//夜間
				else if((j>=14&&j<=20) ||(j>=35&&j<=41)||(j>=56&&j<=62)||(j>=77&&j<=83)||(j>=98&&j<=104)){
					String[] tokens = list.get(j-14).split(",");
					course.add(j+"-"+night+split+tokens[0]+list.get(j));			
				}
			}//end of final for
					
			CompareCourse(classNames.get(i),course,date);
			//System.out.println("before CompareCourse");
			System.out.println(i+" is done");
		}//end of classNames for()**************************
	}//end of getCourse()
			
	private static void CompareCourse(String classNames,List<String>course,String date)throws Exception{
		File file = new File("res\\"+classNames+".csv");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String str=null;
		
		for(int j=0;j<course.size();j++){
			str=in.readLine();
			if(course.get(j).equals(str)){
				continue;	
			}else{
				System.out.println("it's diff");
				File fileOut = new File("res\\"+classNames+".csv");
				PrintWriter out  = new PrintWriter(new FileWriter(fileOut,false));
				for(String c:course){
					out.println(c);
				}
				out.close();
				break;
			}
		}//end of for
		in.close();
	}//end of CompareCourse()

	public static void main(String[] args) throws Exception {
//		int trueyear=Calendar.getInstance().get(Calendar.YEAR);
		//int month=Calendar.getInstance().get(Calendar.MONTH)+1;
		//eg.  FileNames=2015_05_ZB101.txt
		try{
			int year=2015;
			int month=8;
			
			String dateformat=year+"_"+String.format("%02d",month)+"_";
			getClass(year,month,dateformat);
			for(String one:classNames){
				System.out.println(one);
			}
			System.out.println("getClass  OK!");
//			eg. << 2015_5_ZB101 >>
			CompareClassNames(classNames,dateformat);
//			System.out.println("CompareClass  OK!!");
//					
//			getCourse(classNames,year,month,dateformat);
//			System.out.println("getCourse   OK!!!");

//			System.out.printf("year %d is done!",year);
		}catch(Exception e){
			e.printStackTrace();
		}
	}//end of main()
}
