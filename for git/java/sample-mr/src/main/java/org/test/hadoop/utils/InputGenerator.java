package org.test.hadoop.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class InputGenerator {
	private static String website[]=new String[]{
		"google",
		"facebook",
		"youtube",
		"tweeter",
		"yahoo"
	};
	
	public static void main(String args[]) throws IOException{
		FileSystem fs=FileSystem.get(new Configuration());
		Path inputFilePath=new Path("./hdfs/input/input.txt");
		if(!fs.exists(inputFilePath.getParent())){
			fs.mkdirs(inputFilePath.getParent());
		}
		OutputStream out=fs.create(inputFilePath);
		OutputStreamWriter writer=new OutputStreamWriter(out);
		BufferedWriter bufWriter=new BufferedWriter(writer);
		Random r=new Random();
		long ts=System.currentTimeMillis();
		for(int i=0;i<5000;i++){
			int rndIdx=r.nextInt(website.length);
			String rndUser="user-"+(r.nextInt(50));
			String rndSite=website[rndIdx];
			if(i>0){
				bufWriter.write("\n");
			}
			bufWriter.write(ts+","+rndUser+","+rndSite);	
			ts++;
		}
		bufWriter.flush();
		bufWriter.close();
		System.out.println("Input file generated at "+inputFilePath);
	}
}
