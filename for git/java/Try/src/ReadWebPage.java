import java.net.*;
import java.io.*;
 
public class ReadWebPage {
    
    public static void main(String[] arg) throws Exception {
        String web1 = "http://140.115.236.11/query_tea.asp?STR=ZB101&Query=%ACd%B8%DF&MM2=5&YY2=2015&item2=%AFZ%AF%C5" ;//UTF-8 
        //String web2 = "http://bin.ton.net/books_detail.asp?id_book=205"; //Big5
        //String web3 = "http://zh.wikipedia.org/w/index.php?title=%E9%A6%96%E9%A1%B5&variant=zh-tw";
        
        read1(web1);
        //read2(web1);
       // read3(web1);    
        
    }
    
    //�H�o�Ӥ�k���X�Ӫ��ɮפ��e�榡�A�̦X�A�A���|�ñ��A�]���κ޺����s�X
    public static void read1( String strURL ) {
          int chunksize = 4096;
        byte[] chunk = new byte[chunksize];
        int count;
        try  {    
            URL pageUrl = new URL(strURL );
       
            // Ū�J����(�줸��y)
            BufferedInputStream bis = new BufferedInputStream(pageUrl.openStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("URL1.txt", false));
            System.out.println("read1() running " );
            while ((count = bis.read(chunk, 0, chunksize)) != -1) {
                bos.write(chunk, 0, count); // �g�J�ɮ�
            }
            bos.close();
            bis.close();     
          
          System.out.println("Done");   
         }catch (IOException e) {
             e.printStackTrace();
         }
      }
    
    
     
    //*******************************************************************************************
    ///�H�o�Ӥ�k���X�Ӫ��ɮפ��e�榡�A�ܦ��@��A�����\Ū�A�ݪ`�N�����s�X
    public static void read2( String strURL ) {
        System.out.println("read2() running");

        try {
            URL url_address = new URL( strURL );
            
            // Ū�J����(�r����y)            
            BufferedReader br = new BufferedReader(new InputStreamReader(url_address.openStream(), "UTF-8"));
            //BufferedReader br = new BufferedReader(new InputStreamReader(url_address.openStream(), "Big5"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("URL2.txt", false));    
            String oneLine = null ;
            
            while ((oneLine = br.readLine()) != null) {
                bw.write(oneLine);                
            }
            bw.close();
            br.close();
            
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Done");
    }
    
    
    //*******************************************************************************************
    //�H�o�Ӥ�k���X�Ӫ��ɮפ��e�榡�A�ܦ��@��A�����\Ū�A�ݪ`�N�����s�X
    public static void read3( String strURL ) {
        System.out.println("read3() running");
        try {
            String line = null;
            //�t�@�سs���������覡
            URL url = new URL(strURL);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.connect();
            InputStream is = uc.getInputStream();
            
            /// Ū�J����(�r����y)
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
            //BufferedReader br = new BufferedReader(new InputStreamReader(url_address.openStream(), "Big5"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("URL3.txt", false));    
            
            while ((line = br.readLine()) != null) {
                bw.write(line);            
            }
            br.close();
            bw.close();
        }
        catch(Exception e) {
            System.out.println("�o�ͤF" + e + "�ҥ~");
        }
        System.out.println("Done");
    }
   
    /* �H�U�o�O�e���������A�ѩ��٨S�����|�ΡA�ҥH����b�o�̯d���@�U

        �Y�OŪ���R�A���ɮ�, �B�n���D���ɮפ����w�r���s�X, �ߤ@����k�N�O
        �H ByteArrayInputStream �hŪ���ɮ�, �åB��O���ɮ����Y���줸�լ���
        ��O�ɮת���k, ��Ū�������ɮ�, �A�ϧO
        utf-8 �e�Tbytes ���O�� -17,-65,-69 ----> offset=3
        utf-16le �e�Gbytes ���O�� -1,-2 ----> offset=2
        utf-16be �e�Gbytes ���O�� -2,-1 ----> offset=2
        MS950, BIG5, .... �L ----> offset=0;
        Ū����A�I�s new String(����bytes,offset,����bytes����,"�s�X�覡")
        �ন�r�� 
*/
}