package com.iii.advance;

public class EmpRec{
	private String empno;
	private double salary;
	public EmpRec(String empno,double salary){
		this.empno = empno;
		this.salary = salary;
	}
	public String getEmpno() {
		return empno;
	}
	public double getSalary() {
		return salary;
	}
}