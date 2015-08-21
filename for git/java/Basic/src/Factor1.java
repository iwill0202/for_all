
public class Factor1 {
	static long factorial(int num) {
		long result = 1;
		for (int i = num ; i >=1 ; i--)
			result *= i;
		return result;
	}

	public static void main(String[] args) {
		System.out.println(args[0] + "! = " + factorial(Integer.parseInt(args[0])));
	}

}
