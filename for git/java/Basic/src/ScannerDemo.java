import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		int age = scanner.nextInt();
		scanner.close();
		
		System.out.println("Your name is " + name);
		System.out.println(name + ", your age is " + age);
	} // end of main()
} // end of class ScannerDemo

