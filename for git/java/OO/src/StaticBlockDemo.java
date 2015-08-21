public class StaticBlockDemo {
	int num;
	static int count = 10;
/*	static {
		count = 10;
	} // static block
*/
	public static void main(String[] args) {
		StaticBlockDemo sb = new StaticBlockDemo();
		sb.num++; // ???
		System.out.println(sb.num);
		count++; // ???
		System.out.println(count);
		System.out.println(sb.count);
		System.out.println(StaticBlockDemo.count);
	} // end of main()
} // end of class StaticBlockDemo
