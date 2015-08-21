import java.util.*;
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		String name = scanner.next();
		int age = scanner.nextInt();
		System.out.println("Your name is "+name);
		System.out.println(name+",your age is "+age);
		scanner.close();
	}//end of main
}//end of class ScannerDemo