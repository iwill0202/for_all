package com.iii.Homework_1;
public class Comment {
	public static void main(String[] args) {
		if(Integer.parseInt(args[0])>=80){
			switch(args[1]){
				case "��":System.out.println("Perfect");break;
				case "�A":System.out.println("Fantastic");break;
				case "��":System.out.println("Awesome");break;
			}//switch of if>=80
		}//if>=80
		if(Integer.parseInt(args[0])<80 && Integer.parseInt(args[0])>=60){
			switch(args[1]){
			case "��":System.out.println("Great");break;
			case "�A":System.out.println("Nice");break;
			case "��":System.out.println("Good");break;
			}//switch of if <80 && if >=60
		}//if <80 && if >=60
		if(Integer.parseInt(args[0])<60){
			switch(args[1]){
			case "��":System.out.println("Bad");break;
			case "�A":System.out.println("F");break;
			case "��":System.out.println("FFF");break;
			}//switch of if<60
		}//if<60
	}// end of main
}//end of class