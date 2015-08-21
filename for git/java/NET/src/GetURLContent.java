import java.net.*;
import java.io.*;
public class GetURLContent {
	public static void main(String[] args) throws Exception{
		URL url = new URL(args[0]);
		InputStream is = url.openStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder(1024);
		String str;
		while((str = in.readLine())!=null){
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}
}
