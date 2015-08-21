package com.iii.HomeWork_3;
public abstract class Employee {
	private String ename, sex, address,jobTitle;
	private String hiredate;
	private String phone;
	private int baseSalary;
	private int overTime;
	private int totalSalary;
	
	public Employee() {
	}
	
	public Employee(String jobTitle,String ename, String sex, String address, 
			String hiredate, String phone, int baseSalary, int overTime) {
		this.jobTitle = jobTitle;
		this.ename = ename;
		this.sex = sex;
		this.address = address;
		this.hiredate = hiredate;
		this.phone = phone;
		this.baseSalary = baseSalary;
		this.overTime = overTime;
		this.totalSalary = calculateTotalSalary();//totalSalary 不是被NEW出來的 上面小瓜號的東西都是要NEW的
	}

	public void printProfile() {
		System.out.print("Job Title = " + jobTitle+",  ");
		System.out.print("Name = " + ename+",  ");
		System.out.print("Gender = " + sex+",  ");
		System.out.print("Address = " + address+",  ");
		System.out.print("Hiredate = " + hiredate+",  ");
		System.out.println("Phone Number= " + phone);
	}//end of printProfile
	
	public void printSalary(){
		System.out.println("Total Salary = " + totalSalary);
	}//end of printSalary
	
	public int calculateTotalSalary(){
		totalSalary=(int)(baseSalary+(baseSalary/240)*1.5*overTime);
		return totalSalary;
	}//end of calculateTotalSalary

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public int getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
}//end of class Employee