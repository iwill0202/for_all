package com.iii.Homework_2;

public class TRY {

	public static void main(String[] args) {
		for(int i=0;i<7;i++){
		int a=(1234567%(int)(Math.pow(10,i+1)))/(int)(Math.pow(10,i))*(i+1);
		System.out.println(a);
		}
		/*int midnum=0,sum=0;
		for(int i=0;i<7;i++){//產生中間數字
			midnum+=(int)(Math.random()*(9-0+1)+0)*(int)(Math.pow(10,i));
		}
		System.out.println(midnum);
		for(int j=0;j<7;j++){
			sum+=((midnum%(int)(Math.pow(10,(j+1))))/(int)(Math.pow(10,0)))*(j+1);
			System.out.println(sum);
		}*/
		
	}
}
