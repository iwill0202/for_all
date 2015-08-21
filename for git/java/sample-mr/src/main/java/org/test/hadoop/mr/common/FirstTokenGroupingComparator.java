package org.test.hadoop.mr.common;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class FirstTokenGroupingComparator extends WritableComparator{
	
	public FirstTokenGroupingComparator() {
		super(Text.class,true);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable w1, WritableComparable w2) {
		String a=w1.toString().split(",")[0];
		String b=w2.toString().split(",")[0];
		return a.compareTo(b);
	}
}