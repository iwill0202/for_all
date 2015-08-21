package com.iii.Homework_2;
public class ElectrityBill {
	public static void main(String[] args) {
		if(args[0].equals("home") && Integer.parseInt(args[1])<=240)
			System.out.print("您用的是"+args[0]+"\n"+"您需要繳交"+Integer.parseInt(args[1])*0.15+"元。");
		if(args[0].equals("home") && (Integer.parseInt(args[1])>240 && Integer.parseInt(args[1])<=540))
			System.out.print("您用的是"+args[0]+"\n"+"您需要繳交"+Integer.parseInt(args[1])*0.25+"元。");
		if(args[0].equals("home") && Integer.parseInt(args[1])>540)
			System.out.print("您用的是"+args[0]+"\n"+"您需要繳交"+Integer.parseInt(args[1])*0.45+"元。");
		if(args[0].equals("industy"))
			System.out.print("您用的是"+args[0]+"\n"+"您需要繳交"+Integer.parseInt(args[1])*0.45+"元。");
	}//main
}//class