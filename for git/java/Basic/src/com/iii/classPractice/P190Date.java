package com.iii.classPractice;

import java.util.Calendar;

public class P190Date {
	public static void main(String[] args) {
		String[] week={"日","一","二","三","四","五","六"};
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.getMaximum(Calendar.MONTH)+1;
		int day  = today.get(Calendar.DATE);
		int day_of_week = today.get(Calendar.DAY_OF_WEEK)-1;
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		System.out.print("今天是"+year+"/"+month+"/"+day);
		System.out.println("  星期"+week[day_of_week%7]);
		System.out.println("時間是"+hour+":"+minute+":"+second);
		System.out.printf("時間是 %d:%02d:%02d%n",hour,minute,second);
		
	}

}
