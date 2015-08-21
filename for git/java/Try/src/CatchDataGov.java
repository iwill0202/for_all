import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CatchDataGov {
	public static void main(String[] args) throws Exception {
		try{
			//File file = new File(args[0]);
			//PrintWriter out  = new PrintWriter(new FileWriter(file,false));
			//List<String>list = new ArrayList<String>();
			int y=675;
			
			for(int x=1;x<100;x++){
				URL url = new URL("http://data.gov.tw/taxonomy/term/"+y+"?page="+x);
								 //http://data.gov.tw/taxonomy/term/250?page=8
				Document xmlDoc =  Jsoup.parse(url, 5000); 
				Elements div = xmlDoc.select("div");
				Elements h = xmlDoc.select("h2");
				System.out.println(div.get(162).text());
				if(h.size()>=4){
					System.out.println("Page-"+(x+1));
					for(int i=4;i<14;i++){
						System.out.println(i+"-"+h.get(i).text());
					
					}
				}else{
					break;
				}
				System.out.println("---------------------");
			}
			System.out.println("ok");
			//File file = new File("res\\"+y+".txt");
			//PrintWriter out  = new PrintWriter(new FileWriter(file,false));
			//out.println(list);
			//out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		

}