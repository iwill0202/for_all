import java.io.*;
public class SerializedDemo {
	private static final long servialVersionUID=1L;
	String s;
	int n;
	public SerializedDemo(String s,int n ){
		this.s = s;
		this.n = n;
	}
	public static void main(String[] args) {
		try{
			SerializedDemo st = new SerializedDemo("Good luck",3);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/out.ser"));
			oos.writeObject(st);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res/out.ser"));
			SerializedDemo st1 = (SerializedDemo)ois.readObject();
			oos.close();
			ois.close();
			
			
		}catch(Exception e){}

	}

}
