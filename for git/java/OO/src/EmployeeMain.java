public class EmployeeMain {
	public static void main(String[] args) {
	/*	Employee e1 = new Employee();
	//	e1.empno = 111;
	//	e1.name = "Tom";
		e1.setEmpno(111);
		e1.setName("Tom");
		e1.display();
		Employee e2 = new Employee(222, "Mary");
		e2.display();
	*/	
	/*	Permanent p = new Permanent();
		p.setEmpno(333);
		p.setName("Stephen");
		p.setSalary(35000);
		p.display();
	
		Permanent p1 = new Permanent(444, "Tina", 46000);
		p1.display();
		Temporary t1 = new Temporary(555, "John", 120, 100);
		t1.display();
		Sales s1 = new Sales(666, "David", 12000, 26000);
		s1.display();
	*/	
		Permanent p1 = new Permanent(444, "Tina", 46000);
		Temporary t1 = new Temporary(555, "John", 120, 100);
		Sales s1 = new Sales(666, "David", 12000, 26000);
		System.out.println(p1.paySalary());
		System.out.println(t1.paySalary());
		System.out.println(s1.paySalary());
		System.out.println("==========");
		Employee[] e = new Employee[3];
		e[0] = new Permanent(444, "Tina", 46000);
		e[1] = new Temporary(555, "John", 120, 100);
		e[2] = new Sales(666, "David", 12000, 26000);
		for (int i = 0; i < e.length; i++)
			System.out.println(e[i].paySalary());
		System.out.println("employee count = " + Employee.getEmpCount());
	//	System.out.println(p1.toString());
	}
}
