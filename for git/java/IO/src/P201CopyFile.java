import java.io.*;
public class P201CopyFile {
	public static void main(String[] args){
		String str;
		try{			
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			PrintWriter out  = new PrintWriter(new FileWriter(args[1]));
			StringBuilder sb = new StringBuilder(300);
			while((str = in.readLine())!= null){
				sb.append(str).append("\n");
			}
			out.print(sb);
			//System.out.print(sb);
			in.close(); out.close();
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


*/