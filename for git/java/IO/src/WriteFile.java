import java.io.*;

class WriteFile{
	public static void main(String[] args){
		File filein = new File(args[0]);
		File fileOut = new File(args[1]);
		String str;
		try{
			BufferedReader in  =  new BufferedReader(new FileReader(fileOut));
			//BufferedReader in  =  new BufferedReader(new InputStreamReader(fileOut));
			PrintWriter out  = new PrintWriter(new FileWriter(filein,false));
			StringBuilder sb = new StringBuilder(300);
			while((str = in.readLine())!=null){
				sb.append(str).append("\n");
			}
			System.out.println(sb);
			out.println(sb);
			out.close();in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}//end of main
}//end of class WriteFile