package com.iii.Homework_2;
public class TwoDimArray {
	static double allavg(int[][] twoDim){
		double sum=0.0;
		double avg=0.0;
		int i=0, j=0;
		for(i = 0;i<twoDim.length;i++){
			for(j=0;j<twoDim[i].length;j++){
				sum+=twoDim[i][j];
			}//for j
		}//for i
		avg=sum/(twoDim.length*twoDim[i].length);
		System.out.println("┮Τ计キА = "+avg);
		return avg;
	}//allavg
	
	static int max(int[][] twoDim){
		int sum=0;
		for(int i=0;i<twoDim.length;i++)
			for(int j=0;j<twoDim[i].length;j++){
				if(twoDim[i][j]>sum)
					sum=twoDim[i][j];
			}//for int j
		System.out.println("12计い程= "+sum);
		return sum;
	}//max
	
	static int min(int[][] twoDim){
		int sum=100;
		for(int i=0;i<twoDim.length;i++)
			for(int j=0;j<twoDim[i].length;j++){
				if(twoDim[i][j]<sum)
					sum=twoDim[i][j];
			}//for int j	
		System.out.println("12计い程= "+sum);
		return sum;
	}//min
	
	static double avg(int[][] twoDim){
		double sum=0.0;
		double t=0.0;
		for(int i=0;i<twoDim.length;i++){
			sum=0;
			for(int j=0;j<twoDim[i].length;j++){
				sum+=twoDim[i][j];
			}//for int j
			t=sum/twoDim[i].length;
			System.out.println("材 "+(i+1)+"キА "+t);
		}//for int i
		return t;
	}//avg

	public static void main(String[] args) {
		int[][] twoDim={{1,2,3,4},
				        {5,6,7,8},
			         	{9,10,11,12}};
		allavg(twoDim);//氮a
		max(twoDim);//氮b
		min(twoDim);//氮c
		avg(twoDim);//氮d
	}//main
}//class