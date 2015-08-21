import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetURLContent {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://140.115.236.11/query_tea.asp?STR=ZB101&Query=%ACd%B8%DF&MM2=5&YY2=2015&item2=%AFZ%AF%C5"); 
		Document xmlDoc =  Jsoup.parse(url, 3000); 
		Elements td = xmlDoc.select("td");  
			
			
		//.replaceAll("¡@","")
		for(int i=0;i<td.size();i++){
			String str = (td.get(i).text().replaceAll("¡@",""));
			System.out.println("No"+i+"-"+str);
			//System.out.println("No"+i+"-"+td.get(i).text());	
		}//end of for		
	}
}


