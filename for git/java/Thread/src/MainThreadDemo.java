
public class MainThreadDemo {
	public static void main(String[] args){
		Thread t = Thread.currentThread();
		System.out.println("Before change: "+t.getName());
		t.setName("MainThread");
		System.out.println("After change: "+t.getName());
	}
}
