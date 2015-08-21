import java.util.*;
public class ArrayListDemo {

	public static void main(String[] args) {
		List<Integer>list = new	ArrayList<Integer>();
		list.add(new Integer(12));
		list.add(34);
		list.add(34);
		list.add(50);
		System.out.println("1. "+list);
		System.out.println("2. "+list.size());
		for(int i=0;i<list.size();i++){
			
			System.out.println("3. "+list.get(i));
		}
		for(Integer i:list)
			System.out.println("4. "+i);
	}

}

