package com.iii.HomeWork_3;
public class FirstClassManager extends SecondClassManager{
	private static final int transportAllowance=2000;
	
	FirstClassManager(){
	}
	
	FirstClassManager(String jobTitle,String ename, String sex, String address, 
			String hiredate, String phone, int baseSalary, int overTime){
		super(jobTitle,ename, sex, address, hiredate, phone, baseSalary, overTime);
		//this.transportAllowance = transportAllowance;
	}
	
	public void printProfile() {
		super.printProfile();
	}//end of printProfile
	
	public void printSalary(){
		super.printSalary();
	}//end of printSalary
	
	public int calculateTotalSalary(){
		return super.calculateTotalSalary()+transportAllowance;
	}//end of calculateTotalSalary

	public static int getTransportallowance() {
		return transportAllowance;
	}
}//end of class FirstClassManager
