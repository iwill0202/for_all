package com.iii.Homework_2;
public class Prime {
	public static void main(String[] args) {
		int num=Integer.parseInt(args[0]);
		int sum;
		for(int i=1;i<=num;i++){
			sum=0;
			for(int j=1;j<=i;j++){
				if(i%j==0)
					sum++;
			}
				if(sum==2)
			System.out.print(i+" ");
		}//outer for
	}//main
}//class
