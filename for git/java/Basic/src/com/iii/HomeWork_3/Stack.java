package com.iii.HomeWork_3;

public class Stack {
	private int[] storeData=new int[4];
	private int top=-1;
	
	Stack(){
	}//end of stack
	
	void push(int num)throws stackFullException{
		top++;
		if(top==4){
			throw new stackFullException("Your array is already full!");
		}
		storeData[top]=num;
		System.out.println(num+" is added in the array");
	}//end of push
	
	void pop() throws stackEmptyException{
		if(top==-1){
			throw new stackEmptyException("Your array is already empty!");
		}
		System.out.println(storeData[top]+" is pop out!");
		top--;
	}
	
	
	
	public int[] getStoreData() {
		return storeData;
	}

	public void setStoreData(int[] storeData) {
		this.storeData = storeData;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public static void main(String[] args) throws stackFullException, stackEmptyException{
		Stack s1 = new Stack();
		try{
			s1.push(1);
			s1.push(2);
			s1.push(3);
			s1.push(4);
			s1.pop();
			s1.push(5);
			s1.pop();
			s1.pop();
			s1.pop();
			s1.pop();
			s1.pop();
		}catch (stackFullException f){
			System.out.println(f.getMsg());
		}catch (stackEmptyException e){
			System.out.println(e.getMsg());
		}
	}//end of main
}//end of class

class stackEmptyException extends Exception{
	private static final long serialVersionUID = 1L;
	private String msg;
	stackEmptyException(String msg){
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	
	
}//end of stackEmptyException

class stackFullException extends Exception{
	private static final long serialVersionUID = 1L;
	private String msg;
	stackFullException(String msg){
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
}//end of stackFullException