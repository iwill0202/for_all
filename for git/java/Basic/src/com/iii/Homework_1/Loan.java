package com.iii.Homework_1;
public class Loan {
	public static void main(String[] args) {
		int year, money=100000;
		double tb=0,td=0,tu=0;
		double bankm=0.2/12, downm=0.1, underm=0.01*30;
		for(year=1;year<=12;year++){
			tb=money*(1+bankm*year);
			td=money*(1+downm*year);
			tu=money*(1+underm*year);
		System.out.print("�� "+year+"��"+"�A���ٻȦ�  "+Math.round(tb)+"��");
		System.out.print("�B��Q  "+Math.round(td)+"��");
		System.out.println("�M �a�U����  "+Math.round(tu)+"��");
		}//for
			
	}//main
}//class
//������H100000�����O�V�Ȧ�B��Q�M�a�U�����ɶU�C
//�Y�Ȧ檺�~�Q�v��20%�A��Q��Q�v��10%�M�a�U������Q�v��1%�C
//�H�묰���A�p��@�Ӥ��ܤ@�~��C�Ӥ���k�٦h�ֿ��C