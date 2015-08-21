
public class Factor {
	static long factorial(int num) {
		long result = 1;
		for (int i = num ; i >=1 ; i--)
			result *= i;
		return result;
	}

	public static void main(String[] args) {
		System.out.println("4! = " + factorial(4));
		System.out.println("5! = " + factorial(5));
		System.out.println("10! = " + factorial(10));
		System.out.println("11! = " + factorial(11));
		System.out.println("12! = " + factorial(12));
		System.out.println("13! = " + factorial(13));
	}

}
