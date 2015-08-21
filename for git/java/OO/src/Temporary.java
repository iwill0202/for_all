
public class Temporary  extends Employee {
	private double hourPay;
	private int workHour;
	
	public Temporary(int empno, String name, double hourPay, int workHour) {
		super(empno, name);
		this.hourPay = hourPay;
		this.workHour = workHour;
	}
	
	public double getHourPay() {
		return hourPay;
	}

	public void setHourPay(double hourPay) {
		this.hourPay = hourPay;
	}

	public int getWorkHour() {
		return workHour;
	}

	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}

	public void display() {
		super.display();
		System.out.println("hourPay = " + hourPay);
		System.out.println("workHour = " + workHour);
	}
	
	public double paySalary() {
		return hourPay * workHour;
	}

}
