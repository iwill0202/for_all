package com.iii.Homework_2;
public class ElectrityBill {
	public static void main(String[] args) {
		if(args[0].equals("home") && Integer.parseInt(args[1])<=240)
			System.out.print("�z�Ϊ��O"+args[0]+"\n"+"�z�ݭnú��"+Integer.parseInt(args[1])*0.15+"���C");
		if(args[0].equals("home") && (Integer.parseInt(args[1])>240 && Integer.parseInt(args[1])<=540))
			System.out.print("�z�Ϊ��O"+args[0]+"\n"+"�z�ݭnú��"+Integer.parseInt(args[1])*0.25+"���C");
		if(args[0].equals("home") && Integer.parseInt(args[1])>540)
			System.out.print("�z�Ϊ��O"+args[0]+"\n"+"�z�ݭnú��"+Integer.parseInt(args[1])*0.45+"���C");
		if(args[0].equals("industy"))
			System.out.print("�z�Ϊ��O"+args[0]+"\n"+"�z�ݭnú��"+Integer.parseInt(args[1])*0.45+"���C");
	}//main
}//class