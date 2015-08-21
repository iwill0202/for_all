import java.io.*;
import java.net.*;


public class ChatRoom {
	public static void main (String[] args)throws Exception{
		String host = args[0];
		int port  = Integer.parseInt(args[1]);
		
		ServerSocket server = new ServerSocket(port);
		Socket socketserver = server.accept();
		
		
		
		
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
		server.close();
	}
}
