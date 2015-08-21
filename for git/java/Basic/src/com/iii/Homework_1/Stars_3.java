package com.iii.Homework_1;

public class Stars_3 {
	public static void main(String[] args) {
		int row,column,space;
		for(row=1;row<=5;row++){
			for(space=1;space<=5-row;space++){
				System.out.print(" ");//print space
			}
			for(column=1;column<=row*2-1;column++){
				System.out.print("*");//print star
			}
			System.out.print("\n");
		}//end of outer for	
	}// end of main
}//end of class