package org.test.hadoop.mr.topnext;



import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;



public class SeqReducer extends Reducer<Text, Text, Text, NullWritable> {

	String previous=null;
	String current=null;
	Text outputKey=new Text();
	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
	}

	@Override
	protected void reduce(Text entry, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		Iterator<Text> it=value.iterator();
		while(it.hasNext()){
			if(previous==null){
				previous=it.next().toString();
				continue;
			}else{
				previous=current;
				current=it.next().toString();
			}
			if(previous!=null && !previous.equals(current)){
				outputKey.set(previous+","+current);
				context.write(outputKey, NullWritable.get());
			}
		}
	}
	
	@Override
	protected void cleanup(Context context) throws IOException,
			InterruptedException {
	}
	
}
