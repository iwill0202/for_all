package com.iii.HomeWork_3;

import java.io.*;
import java.util.*;

public class NewEmployeeMain {
		
	public static void main(String[] args){
		List<Employee>list = new ArrayList<Employee>();
		try{
			String str;
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((str = in.readLine())!= null){
				String[] tokens = str.split(",");
				switch(tokens[0]){
				case "GeneralEmployee":
					list.add(new General(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7])));
					break;
				case "SecondClassManager":
					list.add(new SecondClassManager(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7])));
					break;
				case "FirstClassManager":
					list.add(new FirstClassManager(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7])));
					break;	
				}
				
			}//end of while
			//list.get(0).printProfile();
			//String[] tokenss = str.split(",");
			
			for(int i=0;i<list.size();i++){
				System.out.print("½s¸¹ "+(i+1)+" ¸¹     ");
				list.get(i).printProfile();
				list.get(i).printSalary();
				System.out.println("----------------------------------------------------");
			}//end of for
			
			
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}//end of catch
	}//end of main
}//end of class NewEmployeeMain