package com.iii.classPractice;

import java.util.Calendar;

public class P190Date {
	public static void main(String[] args) {
		String[] week={"��","�@","�G","�T","�|","��","��"};
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.getMaximum(Calendar.MONTH)+1;
		int day  = today.get(Calendar.DATE);
		int day_of_week = today.get(Calendar.DAY_OF_WEEK)-1;
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		System.out.print("���ѬO"+year+"/"+month+"/"+day);
		System.out.println("  �P��"+week[day_of_week%7]);
		System.out.println("�ɶ��O"+hour+":"+minute+":"+second);
		System.out.printf("�ɶ��O %d:%02d:%02d%n",hour,minute,second);
		
	}

}
