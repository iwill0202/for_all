import java.util.*;
public class GenericsDemo3<T> {
	
	List<T>list1 = new ArrayList<T>();
	public void push(T val){
		list.add(val);
	}
	public T pop(){
		return list.remove(list.size()-1);
	}

	

}
