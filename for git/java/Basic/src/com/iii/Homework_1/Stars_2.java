package com.iii.Homework_1;

public class Stars_2 {
	public static void main(String[] args) {
		int row,column,space;
		for(row=1;row<=5;row++){
			for(column=5;column>=row;column--)
			System.out.print("*");//print star
			System.out.print("\n");
			for(space=1;space<=row;space++)
			System.out.print(" ");//print space
			}//end of outer for	
	}// end of main
}//end of class