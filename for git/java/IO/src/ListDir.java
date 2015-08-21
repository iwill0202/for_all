import java.io.*;
public class ListDir {
	public static void main(String[] args){
		File file = new File(args[0]);
		if(!file.exists()){
			System.out.println("This isn't a directory!");
			System.exit(0);
		}
		StringBuilder sb = new StringBuilder(300);
		String[] contents = file.list();
		for(int i=0;i<contents.length;i++){
			sb.append(contents[i]).append("\n");
		}
		System.out.print(sb);
	}
}
