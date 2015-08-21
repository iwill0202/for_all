package org.test.hadoop.mr.topnext;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RankReducer extends Reducer<Text, Text, Text, NullWritable> {

	Text outputKey=new Text();
	
	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
	}

	@Override
	protected void reduce(Text entry, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		
		String key=entry.toString();
		String src=key.split(",")[0];
		Iterator<Text> it=value.iterator();
		String lastDst=null;
		int counter=0;
		
		int maxCount=-1;
		String maxDst=null;
		while(it.hasNext()){
			String dst=it.next().toString();
			if(lastDst!=null && !dst.equals(lastDst)){
				if(counter>maxCount){
					maxCount=counter;
					maxDst=dst;
				}
				counter=0;
			}
			lastDst=dst;
			counter++;
		}
		if(counter>maxCount){
			maxCount=counter;
			maxDst=lastDst;
		}
		
		if(src!=null && maxDst!=null){
			outputKey.set(src+","+maxDst);
			context.write(outputKey, NullWritable.get());
		}
	}
	
	@Override
	protected void cleanup(Context context) throws IOException,
			InterruptedException {
	}
}
