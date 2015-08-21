import java.util.*;
public class HashMapDemo {

	public static void main(String[] args) {
		Map<String,String>tel = new HashMap<String,String>();
		tel.put("john","11");
		tel.put("mary","22");
		tel.put("jean","33");
		System.out.println("1. "+tel.get("mary"));
		for(String key:tel.keySet()){
			System.out.println("2. "+key+", "+tel.get(key));
		}
		for(String val:tel.values()){
			System.out.println("3. "+val);
		}
	}

}
