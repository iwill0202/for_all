import java.util.*;
public class GenericsDemo1 {
	public static void print(List<? extends Number>list){
		Iterator<?>iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}//end of print()
	public static void main(String[] args) {
		List<Integer>list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		print(list1);
		List<Double>list2 = new ArrayList<Double>();
		list2.add(5.7);
		list2.add(4.3);
		print(list2);

	}

}
