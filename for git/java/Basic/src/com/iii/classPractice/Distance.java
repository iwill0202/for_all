package com.iii.classPractice;

public class Distance {
	private int inch;
	private int feet;
	
	public Distance(int inch, int feet) throws OverInchException{
		if(inch>=12)
			throw new OverInchException("Inch value over 12, inch=",inch);// 假如這邊不ok下面就不會丟值進去了
		this.feet = feet;
		this.inch = inch;
	}
		
	public int getInch() {
		return inch;
	}
	public int getFeet() {
		return feet;
	}

	public static void main(String[] args) {
		try{
			Distance d1 = new Distance(5,6);
			System.out.println("Feet = "+d1.getFeet()+",Inch = "+d1.getInch());
			Distance d2 = new Distance(13,13);
			System.out.println("Feet = "+d2.getFeet()+",Inch = "+d2.getInch());
		}catch(OverInchException o){
			System.out.println(o.getMsg()+o.getInch());
		}
}//end of class Distance
	
class OverInchException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	private int inch;
	
	public OverInchException(String msg, int feet){
		this.msg = msg;
		this.inch = feet;
	}
	
	public String getMsg() {
		return msg;
	}
	public int getInch() {
		return inch;
	}
	}
}//end of class OverInchException
