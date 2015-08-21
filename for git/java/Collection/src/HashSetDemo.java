import java.util.*;
public class HashSetDemo {

	public static void main(String[] args) {
		Set<Integer>set = new HashSet<Integer>();
		set.add(new Integer(12));
		set.add(34);
		set.add(34);
		//set.add("Hello");
		System.out.println("1. "+set);
		System.out.println("2. "+set.size());
		Iterator<Integer>objs = set.iterator();
		while(objs.hasNext())
			System.out.println("3. "+objs.next());
		for(Integer i:set)
			System.out.println("4. "+i);
	}

}
