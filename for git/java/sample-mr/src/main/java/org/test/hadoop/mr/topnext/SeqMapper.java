package org.test.hadoop.mr.topnext;



import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SeqMapper extends Mapper<LongWritable, Text, Text, Text> {

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
			
			String ts=tokens[0];
			String user=tokens[1];
			String host=tokens[2];
			
			outputKey.set(user+","+ts);
			
			outputValue.set(host);
			
			context.write(outputKey, outputValue);
		}catch(Exception e){
			//ignore
		}
	}
	
	@Override
	protected void cleanup(Context context){
	}	
	
}
