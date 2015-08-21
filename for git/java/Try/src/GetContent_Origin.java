
import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class GetContent_Origin {

	public static void main(String[] args) throws Exception {
		try{
			URL url = new URL("http://140.115.236.11/query_tea.asp?STR=ZB101&Query=%ACd%B8%DF&MM2=5&YY2=2015&item2=%AFZ%AF%C5"); 
			Document xmlDoc =  Jsoup.parse(url, 3000);
		
			Elements td = xmlDoc.select("td"); 
			File file = new File(args[0]);
			PrintWriter out  = new PrintWriter(new FileWriter(file,false));

			for(int i=0;i<td.size();i++){
				out.println("no "+i+" -"+td.get(i).text());
				System.out.println("no "+i+" -"+td.get(i).text()); 
			}
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		

}