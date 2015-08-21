package com.iii.HomeWork_3;
interface Shape{
	public double computeArea();
	public double computeCircumference();
}//interface Shape

public class ShapeMain{
	public static void main(String[] args){
		Circle c1 = new Circle(3.0);
		System.out.println("Circle Radius = "+c1.getRadius());
		System.out.println("Circle Circumference = "+c1.computeCircumference());
		System.out.println("Circle Area = "+c1.computeArea());
		Rectangle r1 = new Rectangle(4.0,3.5);
		System.out.println("Rectangle Width = "+r1.getWidth()+", Rectangle Length = "+r1.getLength());
		System.out.println("Rectangle Circumference = "+r1.computeCircumference());
		System.out.println("Rectangle Area = "+r1.computeArea());
		
	}
}//class ShapeMain

 class Circle implements Shape{
	private double radius;
	public static final double PI = 3.1415926;
	
	Circle(double radius){
		this.radius = radius;
	}//circle
	
	public double computeCircumference(){
		return radius*radius*PI;
	}//circle 
	
	public double computeArea() {
		return radius*radius*PI;
	}//circle Area

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	
}//class Circle

class Rectangle implements Shape{
	private double length;
	private double width;
		
	Rectangle(double length,double width){
		this.length = length;
		this.width = width;
	}//circle
	
	public double computeCircumference(){
		return 2*(length+width);
	}//circle 
	
	public double computeArea() {
		return width*length;
	}//circle Area

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	
}//class Rectangle