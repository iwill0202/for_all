
public class Sales extends Permanent {
	private double commission;
	
	public Sales(int empno, String name, double salary, double commission) {
		super(empno, name, salary);
		this.commission = commission;
	}
	
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public void display() {
		super.display();
		System.out.println("commission = " + commission);
	}
	
	public double paySalary() {
		return super.paySalary() + commission;
	}
}
