package com.iii.XXX;

public abstract class Employee {
	private String name;
	private String gender;
	private String hireDate;
	private String telephone;
	private String address;
	private int salary;
	private int totalSalary;
	private int overtimeHours;
	private int overtimePay;
	public static final int lunchAllowance=1800;
	public static final int trafficAllowance=2000;
	public static final int topDutyAllowance=5000;
	public static final int middleDutyAllowance=3000;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(int overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	public int getOvertimePay() {
		return overtimePay;
	}
	
	private int  calculateOvertimePay() {
		overtimePay=(int)((salary/240)*1.5*overtimeHours);
		return overtimePay;
	}

	public int getTotalSalary(){
		totalSalary=salary +overtimePay;
		return totalSalary;
	}
	
	public void printProfile(){
		System.out.println("Name : "+name);
		System.out.println("Gender : "+gender);
		System.out.println("Hire date : "+hireDate);
		System.out.println("Telephone : "+telephone);
		System.out.println("Address : "+address);
	}
	
	public void printSalayDetail(){
		System.out.println("Basic salary : "+ salary);
		System.out.println("Overtime hours : "+overtimeHours);
		System.out.println("Overtime pay : "+overtimePay);
		
	}
	public Employee(){
		
	}
	
	public Employee(String name,String gender,String hireDate,String telephone,
					String address, int salary,int overtimeHours){
		this.name=name;
		this.gender=gender;
		this.hireDate=hireDate;
		this.telephone=telephone;
		this.address=address;
		this.salary=salary;
		this.overtimeHours=overtimeHours;
		this.overtimePay = calculateOvertimePay();//Special!!!!!!!!!!
		
	}
	

	public static void main(String args[]){
		
		Employee[] emps = new Employee[6];
		emps[0]= new GeneralEmployee("Tom","Male","2014/01/01","03-12345678","Chungli",28000,0);
		emps[1]= new GeneralEmployee("Mary","Female","2014/03/01","03-87654321","Taipei",28000,40);
		emps[2]= new middleEmployee("Jerry","Male","2011/01/01","04-24516669","Taichung",35000,0);
		emps[3]= new middleEmployee("May","Female","2010/01/01","07-44556689","Kaoshiung",35000,28);
		emps[4]= new TopEmployee("Justin","male","2000/07/17","03-3252020","Taoyuan",50000,0);
		emps[5]= new TopEmployee("Jimmy","male","1983/08/24","02-22225555","Taipei",50000,80);
		
		for(int i=0;i<6;i++){
			System.out.println("No."+(i+1));
			emps[i].printProfile();
			emps[i].printSalayDetail();
			System.out.println("Total salary : "+emps[i].getTotalSalary());
			System.out.println("---------------------------------------------------");
		}
		
	}//end of main
}//end of class Employee

class GeneralEmployee extends Employee{
	
	public GeneralEmployee(){
	}
	
	public GeneralEmployee(String name,String gender,String hireDate,String telephone,String address, int salary,int overtimeHours){
		super( name, gender, hireDate, telephone, address,  salary, overtimeHours);
		
	}
	
}//end of class GeneralEmployee

class TopEmployee extends Employee{
	
	public TopEmployee(){
		
	}
	
	public TopEmployee(String name,String gender,String hireDate,String telephone,String address, int salary,int overtimeHours){
		super( name, gender, hireDate, telephone, address,  salary, overtimeHours);
		
	}
	
	public int getTotalSalary(){
		return super.getSalary() + super.getOvertimePay()+Employee.lunchAllowance+Employee.trafficAllowance+Employee.topDutyAllowance;
	}
	
	public void printSalayDetail(){
		super.printSalayDetail();
		System.out.println("Lunch allowance : "+ Employee.lunchAllowance);
		System.out.println("Traffic allowance : "+ Employee.trafficAllowance);
		System.out.println("Duty allowance : "+ Employee.topDutyAllowance);
	}
}// end of class TopEmployee

class middleEmployee extends Employee{
	
	public middleEmployee(){
		
	}
	
	public middleEmployee(String name,String gender,String hireDate,String telephone,String address, int salary,int overtimeHours){
		super( name, gender, hireDate, telephone, address,  salary, overtimeHours);
		
	}
	
	public int getTotalSalary(){
		return super.getSalary() + super.getOvertimePay()+Employee.lunchAllowance+Employee.middleDutyAllowance;
	}
	
	public void printSalayDetail(){
		super.printSalayDetail();
		System.out.println("Lunch allowance : "+ Employee.lunchAllowance);		
		System.out.println("Duty allowance : "+ Employee.middleDutyAllowance);
	}
}//end of middleEmployee
