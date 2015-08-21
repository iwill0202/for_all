import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {
	public static void main(String[] args){
		File file = new File("res\\May.txt");
		//System.out.println("hi");
		int i=0;
		String str;
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			//StringBuilder sb = new StringBuilder(300);
			while((str = in.readLine())!=null){
				
				System.out.println(i+"-"+str);
				//System.out.println(i);
				i++;
				//sb.append(str).append("\n");
			}
			//System.out.println(sb);
			in.close();
		}catch(IOException e){}
	}
}
