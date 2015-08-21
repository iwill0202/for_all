public class MainArgsDemo {
	public static void main(String[] args) {
		String name = args[0];
		int age = Integer.parseInt(args[1]);
		System.out.println("Your name is " + name);
		System.out.println(name + ", your age is " + age);
	} // end of main()
}
