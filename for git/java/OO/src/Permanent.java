
public class Permanent extends Employee {
	private double salary;
	
	public Permanent () {
	}
	
	public Permanent (int empno, String name, double salary) {
		super(empno, name);
		this.salary = salary;
	}
		
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void display() {
		super.display();
		System.out.println("salary = " + salary);
	}
	
	public double paySalary() {
		return salary;
	}

}
