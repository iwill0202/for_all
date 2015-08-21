package com.iii.classPractice;

public class CheckingAccount extends Account {
	int checkCount;
	CheckingAccount(String accountNo,double balance,int checkCount){
		super(accountNo,balance);
		this.checkCount=checkCount;
	}
	void printAccDate(){
		super.printAccDate();
		System.out.println("checkCount= "+checkCount);
	}
	

	public static void main(String[] args) {
		CheckingAccount c1=new CheckingAccount("837444",18730.0,20);
		c1.printAccDate();
	}
}
