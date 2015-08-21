package com.iii.HomeWork_3;

public class SecondClassManager extends Employee {
	private static final int lunchAllowance=1800;
	private static final int dutyAllowance=3000;
	
	public SecondClassManager () {
	}
	public SecondClassManager(String jobTitle,String ename, String sex, String address, 
			String hiredate, String phone, int baseSalary, int overTime){
		super(jobTitle,ename, sex, address, hiredate, phone, baseSalary, overTime);
		//this.dutyAllowance = dutyAllowance;
	}//end of SecondClassManager
	
	public void printProfile() {
		super.printProfile();
	}//end of printProfile
	
	public void printSalary(){
		super.printSalary();
	}//end of printSalary
	
	public int calculateTotalSalary(){
		int totalSalary=(super.calculateTotalSalary()+lunchAllowance+dutyAllowance);
		return totalSalary;
	}//end of calculateTotalSalary
	
	public static int getLunchallowance() {
		return lunchAllowance;
	}
	public int getDutyAllowance() {
		return dutyAllowance;
	}
	
}//end of class SecondClassManager