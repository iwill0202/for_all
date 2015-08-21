import java.io.*;
public class KeyboardInputDemo {
	public static void main (String[] args){
		String str;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try{
			while(!(str = in.readLine()).equals("")){
				System.out.println(str);
				
			}
			in.close();
		}catch(Exception e){e.printStackTrace();}
		
	}
}
