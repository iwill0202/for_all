public abstract class Employee {
	private int empno;
	private String name;
	private static int empCount;
	
	public Employee() {
		empCount++;
	}
	
	public Employee(int empno, String name) {
		this.empno = empno;
		this.name = name;
		empCount++;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getEmpno() {
		return empno;
	}
	
	public String getName() {
		return name;
	}
	
	public static int getEmpCount() {
		return empCount;
	}
	
	public void display() {
		System.out.println("empno = " + empno);
		System.out.println("name = " + name);
	}
	
/*	public double paySalary() {
		return 0;
	}*/
	
	public abstract double paySalary();
}
