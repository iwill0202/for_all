

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetTeachersName {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://140.115.236.11/NEXT2.ASP?YY=2015&MM=5&Query_item=%B1%D0%AEv&NEXT=%A4U%A4%40%A8B"); 
		Document xmlDoc =  Jsoup.parse(url, 3000); 
		
		Elements option = xmlDoc.select("option");  

		for(int i=1;i<option.size();i++){
			System.out.println("No"+i+"-"+option.get(i).text());
		}
		//41--5¢¬7 ¶À»y©ý¡@ ¡@¡@¡@°ÊºAºô­¶ ¡@¡@¡@310
		//63--5¢¬11 ÁÂ³¹¤É¡@ ¡@¡@¡@SPSS ¡@¡@¡@310
		//5¢¬30 ³¯«Û»Ê¡@ ¡@¡@¡@Linux ¡@¡@¡@310
		/*String a = td.get(18).text();//5¢¬2 §d®a»ô¡@ ¡@¡@¡@DM ¡@¡@¡@310--21
		//System.out.println(a.substring(4,7));//get teacher's name
		String[] tokens = a.split(" ¡@¡@¡@");
		System.out.println(tokens[0]+","+tokens[1]);
		System.out.println(a.replaceAll(" ¡@¡@¡@",","));*/
	}
}
