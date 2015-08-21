public class PassDemo {
	int data;

	void passInt(int value) {
		value = 22;
	}

	void passObj(PassDemo ref) {
		ref.data = 99;
	}

	public static void main(String[] args) {
		int val = 11;
		PassDemo pt = new PassDemo();
		pt.passInt(val);
		System.out.println(val);
		pt.data = 101;
		pt.passObj(pt);
		System.out.println(pt.data);
	}
} // end of class PassDemo

