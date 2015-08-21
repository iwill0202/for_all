package com.iii.Homework_1;
public class Interest {
	public static void main(String[] args) {
		double simple=100000,compound=100000;
		double rsim=0.1,rcom=0.05;
		int year;
		for(year=1;simple>=compound;year++){
			simple=100000*(1+(year*rsim));
			compound*=(1+rcom);
		}//for
		System.out.println("第"+(year-1)+"年");
		System.out.print("郝細算 = "+Math.round(compound)+"元"+"\n"+"錢精打 = "+Math.round(simple)+"元");
	}//main
}//class