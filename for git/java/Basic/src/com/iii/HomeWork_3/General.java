package com.iii.HomeWork_3;

public class General extends Employee {
	public General(String jobTitle,String ename, String sex, String address, 
			String hiredate, String phone, int baseSalary, int overTime) {
		super(jobTitle,ename, sex, address, hiredate, phone, baseSalary, overTime);
	}
	public void printProfile() {
		super.printProfile();
	}//end of printProfile
	
	public void printSalary(){
		super.printSalary();
	}//end of printSalary
}//end of class General
