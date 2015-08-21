
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
//import java.util.*;
//import java.io.*;
public class GetContent_One {
	
	public static void main(String[] args){
		try{
			URL url = new URL("http://140.115.236.11/query_tea.asp?STR=ZB101&Query=%ACd%B8%DF&MM2=5&YY2=2015&item2=%AFZ%AF%C5"); 
			Document xmlDoc =  Jsoup.parse(url, 3000); 
			Elements td = xmlDoc.select("td");  
			
			List<String>list = new ArrayList<String>();
			/**把表格重製，從第一週開始 第11個td*/
			
			for(int i=11;i<td.size();i++){
				String newTd = td.get(i).text();
				if(newTd.length()>5){
					list.add(newTd.replaceAll("　","").trim().replaceAll(" ",","));
				}else{
					list.add(newTd.replaceAll("　","").trim());
				}
			}//end of for
			/**製成 final csv
			 大於小於 是為了取得每一週的上午下午夜間的間隔
			 一個月以五週來說
			 所以 if 裡面總共會有 五個大於小於 中間以 or 連接
			 目前大於小於是硬砍砍出來的 看有沒有人有更好的想法來寫
			 */
			
			String morning="上午";
			String afternoon="下午";
			String night="夜間";
			List<String>outlist = new ArrayList<String>();
			//StringBuffer sb = new StringBuffer(300);
			
			//File file = new File("res\\a.txt");
			//PrintWriter out  = new PrintWriter(new FileWriter(file,false));
			
			for(int j=0;j<list.size();j++){
				int listLength = list.get(j).length();
				//上午
				if((j>1&&j<9) ||(j>26&&j<34)||(j>51&&j<59)||(j>76&&j<84)||(j>101&&j<109)){
					if(listLength>2&&listLength!=5){
						//sb.append(morning+",").append(list.get(j)+"\n");				
						//out.println(morning+","+list.get(j));
						outlist.add(j+"-"+morning+","+list.get(j));
					}
				}
				//下午
				else if((j>9&&j<17) ||(j>34&&j<42)||(j>59&&j<67)||(j>84&&j<92)||(j>109&&j<117)){
					if(listLength>2&&listLength!=5){
						String[] tokens = list.get(j-8).split(",");
						//sb.append(afternoon).append(",").append(tokens[0]).append(",").append(list.get(j)+"\n");				
						//out.println(afternoon+","+tokens[0]+","+list.get(j));
						outlist.add(j+"-"+afternoon+","+tokens[0]+","+list.get(j));
					}
				}
				//夜間
				else if((j>17&&j<25) ||(j>42&&j<50)||(j>67&&j<75)||(j>92&&j<100)||(j>117&&j<125)){
					if(listLength>2&&listLength!=5){
						String[] tokens = list.get(j-16).split(",");
						//sb.append(night).append(",").append(tokens[0]).append(",").append(list.get(j)+"\n");				
						//out.println(night+","+tokens[0]+","+list.get(j));
						outlist.add(j+"-"+night+","+tokens[0]+",*,"+list.get(j));
					}
				}
				else{
					//sb.append(list.get(j)+"\n");
					//out.println(list.get(j));
					outlist.add(j+"-"+list.get(j));
				}
			}//end of final csv for
			/**寫入檔案 */
			//System.out.println(sb);
			
			//out.println(sb);
			for(String a:outlist)
				System.out.println(a);
			//out.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


