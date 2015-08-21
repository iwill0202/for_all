package com.iii.classPractice;
import java.io.*;
public class P201CopyFile {
	public static void main(String[] args){
		File file = new File(args[0]);
		String str;
		try{
			FileReader ir = new FileReader(file);
			BufferedReader in = new BufferedReader(ir);
			StringBuilder sb = new StringBuilder(300);
			while((str = in.readLine())!= null){
				sb.append(str).append("\n");
			}
			System.out.print(sb);
			in.close(); ir.close();
		}catch(IOException e){
			e.printStackTrace();
		}//end of catch
	}
}
/*
class ReadFile{
public static void main(String[] args){
		File file = new File(args[0]);
		String str;
		try{
			FileReader ir = new FileReader(file);
			BufferedReader in = new BufferedReader(ir);
			StringBuilder sb = new StringBuilder(300);
			while((str = in.readLine())!= null){
				sb.append(str).append("\n");
			}
			System.out.print(sb);
			in.close(); ir.close();
		}catch(IOException e){
			e.printStackTrace();
		}//end of catch
	}//end of main
}//end of class ReadFile

class WriteFile{
	public static void main(String[] args){
		File file = new File(args[0]);
		String str;
		try{
			BufferedReader in  =  new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out  = new PrintWriter(new FileWriter(file));
			StringBuilder sb = new StringBuilder(300);
			while(!(str = in.readLine()).equals("")){
				sb.append(str).append("\n");
			}
			out.println(sb);
			in.close(); out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}//end of main
}//end of class WriteFile
*/