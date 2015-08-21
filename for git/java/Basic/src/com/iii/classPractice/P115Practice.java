package com.iii.classPractice;

public class P115Practice {
	public static void main(String[] args) {
		Account a = new Account("345677", 345600);
		a.printAccData();
		CheckingAccount ca = new CheckingAccount("46547678", 56700, 30);
		ca.printAccData();
		
		Account[] aa= new Account[2];
		aa[0]=new Account("345677", 345600.0);
		aa[1]=new CheckingAccount("46547678", 56700.0, 30);
		for(int i=0;i<aa.length;i++){
			aa.printAccData();
		}
	} // end of class AccountMain

class Account {
	String accountNo;
	double balance;
		
	Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
		
	void printAccData() {
		System.out.println("accountNo = " + accountNo);
		System.out.println("balance = " + balance);
	}
} // end of class Account

class CheckingAccount extends Account {
		int checkCount;
		
		CheckingAccount(String accountNo, double balance, int checkCount) {
			super(accountNo, balance);
			this.checkCount = checkCount;
		}
		
		void printAccData() {
			super.printAccData();
			System.out.println("checkCount = " + checkCount);
		}
	} // end of class CheckingAccount
}

