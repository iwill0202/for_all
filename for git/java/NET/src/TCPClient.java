import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main (String[] args)throws Exception{
		String host = args[0];
		int port  = Integer.parseInt(args[1]);
		Socket socket  = new Socket(host,port);
		OutputStream os = socket.getOutputStream();
		PrintWriter out = new PrintWriter(new OutputStreamWriter(os));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String msg = in.readLine();
			out.println(msg);
			out.flush();
			if(msg.equals("bye")){break;}
		}
		socket.close();
	}
}
