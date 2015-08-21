public class StringDemo {

	public static void main(String[] args) {
		String str = "Hello world, welcome to Java world.";
		System.out.println(str.charAt(6));
		int len = str.length();
		System.out.println(len);
		System.out.println(str.substring(13));
		System.out.println(str.substring(0,11));
		System.out.println(str.indexOf("world"));
		System.out.println(str.indexOf("World"));
		System.out.println(str.indexOf("world", 7));
		System.out.println(str.lastIndexOf("world"));
		String[] tokens = str.split(" ");
		for (int i = 0; i < tokens.length; i++)
			System.out.println(tokens[i]);
		System.out.println(str.startsWith("hello"));
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
				
		String str1 = "HelloWorld.java"; 
		System.out.println(str1.endsWith(".java"));
		
		String str2 = "2015-02-10";
		System.out.println(str2.replace('-', '/'));
		System.out.println(str2.replaceAll("-", "/"));
		
		String str3 = "Hello world";
		String str4 = "hello world"; 
		System.out.println(str3.compareTo(str4));
		System.out.println(str4.compareTo(str3));

		
	}

}
