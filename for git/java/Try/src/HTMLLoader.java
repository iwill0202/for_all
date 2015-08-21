

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;



public class HTMLLoader {

	public static void main(String[] args) {
		
		File file = new File("D:\\MonthlyWeatherssssss.csv");
		//File jsonFile=new File("E:\\MonthlyWeather.json");
		try{
			PrintWriter out = new PrintWriter(new FileWriter(file,false));
			//PrintWriter outJson=new PrintWriter(new FileWriter(jsonFile,false));
			StringBuilder sb= new StringBuilder(1024);
			//StringBuilder sbJson=new StringBuilder(1024);
			//sb.append("Year,Month,測站,平均溫度,最高溫度,最低溫度,雨量,最大十分鐘風速,最大瞬間風速,平均相對濕度,最小相對濕度,氣壓,降水日數,日照時數\n");
			for(int y=2006;y<=2015;y++){
				for(int m=1;m<=12;m++){
					Document doc = Jsoup.connect("http://www.cwb.gov.tw/V7/climate/monthlyData/Data/mD"+y+m+".htm").get();
					//Document doc = Jsoup.connect("http://www.cwb.gov.tw/V7/climate/monthlyData/Data/mD201512.htm").get();
					Elements list;
					if(!doc.getElementsByAttributeValue("summary", "每月氣象資料").isEmpty())
						list = doc.getElementsByAttributeValue("summary", "每月氣象資料").get(0).children().get(0).children();
					else
						continue;
					for(int i=2;i<list.size();i++){
						Elements tdlist = list.get(i).children();
						sb.append(y+",");
						sb.append(m+",");
						for(Element j :tdlist){
							if(j.html().contains("/")){
								String[] str= j.html().split("/");
								for(int k=0;k<str.length;k++)
									sb.append(str[k]+",");
							}else{
								sb.append(j.html());
								sb.append(",");
							}
						}
						sb.deleteCharAt(sb.lastIndexOf(","));
						sb.append("\n");				
					}
					
				
					System.out.println(y+"-"+m+" 輸出完成");
				}
			}
			out.println(sb);
			out.close();

		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
