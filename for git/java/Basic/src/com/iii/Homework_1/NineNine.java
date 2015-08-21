package com.iii.Homework_1;
public class NineNine {
	public static void main(String[] args) {
		System.out.println("  "+"|"+"\t"+1+"\t"+2+"\t"+3+"\t"+4+"\t"+5+"\t"+6+"\t"+7+"\t"+8+"\t"+9);
		System.out.println("--------------------------------------------------------------------------");
		int i,j;
		for(i=9;i>0;i--){
			System.out.print(i+" |"+"\t");
			for(j=1;j<=i;j++){
				System.out.print(i*j+"\t");
			}
			System.out.println("\n");
		}
	}//main
}//class
