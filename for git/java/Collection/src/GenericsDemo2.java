import java.util.*;
public class GenericsDemo2 {
	public static void print(List<?>list){
		Iterator<?>iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}//end of print()
	public static void main(String[] args) {
		List<Integer>list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		print(list1);
		List<String>list2 = new ArrayList<String>();
		list2.add("hello");
		list2.add("hi");
		print(list2);

	}

}
