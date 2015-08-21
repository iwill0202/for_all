
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetContent {
	
	public static void main(String[] args){
		try{
			URL url = new URL("http://140.115.236.11/query_tea.asp?STR=ZB101&Query=%ACd%B8%DF&MM2=5&YY2=2015&item2=%AFZ%AF%C5"); 
			Document xmlDoc =  Jsoup.parse(url, 3000); 
			Elements td = xmlDoc.select("td");  
			
			List<String>list = new ArrayList<String>();
			/**���歫�s�A�q�Ĥ@�g�}�l ��11��td*/
			
			for(int i=11;i<td.size();i++){
				String newTd = td.get(i).text();
				if(newTd.length()>5){
					list.add(newTd.replaceAll("�@","").trim().replaceAll(" ",","));
				}else{
					list.add(newTd.replaceAll("�@","").trim());
				}
			}//end of for
			/**�s�� final csv
			 �j��p�� �O���F���o�C�@�g���W�ȤU�ȩ]�������j
			 �@�Ӥ�H���g�ӻ�
			 �ҥH if �̭��`�@�|�� ���Ӥj��p�� �����H or �s��
			 �ثe�j��p��O�w���X�Ӫ� �ݦ��S���H����n���Q�k�Ӽg
			 */
			
			String morning="�W��";
			String afternoon="�U��";
			String night="�]��";
			StringBuffer sb = new StringBuffer(300);
			for(int j=0;j<list.size();j++){
				int listLength = list.get(j).length();
				//�W��
				if((j>1&&j<9) ||(j>26&&j<34)||(j>51&&j<59)||(j>76&&j<84)||(j>101&&j<109)){
					if(listLength>2&&listLength!=5){
						sb.append(morning+",").append(list.get(j)+"\n");				
					}
				}
				//�U��
				else if((j>9&&j<17) ||(j>34&&j<42)||(j>59&&j<67)||(j>84&&j<92)||(j>109&&j<117)){
					if(listLength>2&&listLength!=5){
						String[] tokens = list.get(j-8).split(",");
						sb.append(afternoon).append(",").append(tokens[0]).append(",").append(list.get(j)+"\n");				
					}
				}
				//�]��
				else if((j>17&&j<25) ||(j>42&&j<50)||(j>67&&j<75)||(j>92&&j<100)||(j>117&&j<125)){
					if(listLength>2&&listLength!=5){
						String[] tokens = list.get(j-16).split(",");
						sb.append(night).append(",").append(tokens[0]).append(",").append(list.get(j)+"\n");				
					}
				}
				else{
					sb.append(list.get(j)+"\n");
				}
			}//end of final csv for
			/**�g�J�ɮ� */
			System.out.println(sb);
			//File file = new File(args[0]);
			//PrintWriter out  = new PrintWriter(new FileWriter(file,false));
			//out.println(sb);
			//out.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


