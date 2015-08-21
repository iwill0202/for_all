package org.test.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.test.hadoop.mr.common.FirstTokenGroupingComparator;
import org.test.hadoop.mr.common.FirstTokenPartitioner;
import org.test.hadoop.mr.topnext.RankMapper;
import org.test.hadoop.mr.topnext.RankReducer;
import org.test.hadoop.mr.topnext.SeqMapper;
import org.test.hadoop.mr.topnext.SeqReducer;

public class TopNextDriver {
	public int execute(Path inputPath, Path tmpPath, Path outputPath) throws IOException {
		
		Path tmpResultPath = new Path(tmpPath,"topNextTmp");
		
		Configuration conf=new Configuration();
		
		FileSystem fs = FileSystem.get(conf);
		
		if(!fs.exists(tmpPath)){
			fs.mkdirs(tmpPath);
		}
		
		boolean success = false;
		try {
			fs.delete(tmpResultPath, true);
			Job job = Job.getInstance(conf);
			job.setInputFormatClass(TextInputFormat.class);
			FileInputFormat.setInputPaths(job, inputPath);
			job.setMapperClass(SeqMapper.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			job.setGroupingComparatorClass(FirstTokenGroupingComparator.class);
			job.setPartitionerClass(FirstTokenPartitioner.class);
			job.setReducerClass(SeqReducer.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(NullWritable.class);
			job.setNumReduceTasks(3);
			
			FileOutputFormat.setOutputPath(job, tmpResultPath);
			job.setJarByClass(job.getMapperClass());
			success = job.waitForCompletion(true);

		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		}
		if (!success) {
			System.out.println("Job failed");
			return -1;
		}

		success = false;
		try {
			
			fs.delete(outputPath, true);
			Job job = Job.getInstance(conf);
			job.setInputFormatClass(TextInputFormat.class);
			FileInputFormat.setInputPaths(job, tmpResultPath);
			job.setMapperClass(RankMapper.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			job.setGroupingComparatorClass(FirstTokenGroupingComparator.class);
			job.setPartitionerClass(FirstTokenPartitioner.class);
			job.setReducerClass(RankReducer.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(NullWritable.class);
			FileOutputFormat.setOutputPath(job, outputPath);
			job.setNumReduceTasks(3);
			job.setJarByClass(job.getMapperClass());
			success = job.waitForCompletion(true);
			
		} catch (Exception e) {
			success = false;
		}
		if (!success) {
			System.err.println("Job failed");
			return -1;

		}
		System.out.println("Job finished succesfully, results stored at '"+outputPath.toString()+"'");
		return 0;

	}

	public static void main(String args[]) throws IOException {
		Path inputPath = new Path("hdfs/input");
		Path tmpPath = new Path("hdfs/tmp");
		Path outputPath = new Path("hdfs/output");
		new TopNextDriver().execute(inputPath, tmpPath, outputPath);
	}
}
