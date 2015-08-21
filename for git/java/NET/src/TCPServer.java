import java.io.*;
import java.net.*;


public class TCPServer {

	public static void main(String[] args) throws Exception{
		int port  = Integer.parseInt(args[0]);
		ServerSocket ss = new ServerSocket(port);
		Socket socket = ss.accept();
		
		InputStream is = socket.getInputStream();
		BufferedReader in  = new BufferedReader(new InputStreamReader(is));
		while(true){
			String msg = in.readLine();
			String host = socket.getInetAddress().getHostName();
			System.out.println(host+":"+msg);
			if(msg.equals("bye")){break;}
		}
		ss.close();
		socket.close();
	}

}
