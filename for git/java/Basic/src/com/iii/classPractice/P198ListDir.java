package com.iii.classPractice;
import java.io.*;
public class P198ListDir {

	public static void main(String[] args) {
		File file = new File(args[0]);
		if(!file.isDirectory()){
			System.err.println("Not a directory");
			return;
		}
		
		StringBuilder sb = new StringBuilder(300);
		//String[] contents =  file.list();//字串無法做三元運算子
		File[] contents =  file.listFiles();
		
		for(File f:contents){
			//sb.append(f).append("\n");
			sb.append(f.isFile()? "File: ":"Directory: ");
			sb.append(f.getName()).append("\n");
		}
		System.out.print(sb);
	}

}
