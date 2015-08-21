package org.test.hadoop.mr.topnext;



import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class RankMapper extends Mapper<LongWritable, Text, Text, Text> {

	Text outputKey=new Text();
	Text outputValue=new Text();
	
	@Override
	protected void setup(Context context){
	}
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		try{
			String line=value.toString();
			String tokens[]=line.split(",");
			//String src=tokens[0];
			String dst=tokens[1];
			outputKey.set(line);
			outputValue.set(dst);
			context.write(outputKey, outputValue);
		}catch(Exception e){
			//ignore errors
		}
	}
	
	@Override
	protected void cleanup(Context context){
	}	
	
}
