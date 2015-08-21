package com.iii.classPractice;

public class Account {
	String accountNo;
	double balance;
	
	Account(String accountNo,double balance){
		this.accountNo=accountNo;
		this.balance=balance;
	}//acount
	void printAccDate(){
		System.out.println("accountNo= "+accountNo);
		System.out.print("balance= "+balance);
	}
	
	public static void main(String[] args) {
		Account p1=new Account("124654",50000.0);
		p1.printAccDate();
		
	}

}
