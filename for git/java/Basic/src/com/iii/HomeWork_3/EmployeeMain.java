package com.iii.HomeWork_3;

public class EmployeeMain {
	
	public static void main(String[] args){
		Employee[]e=new Employee[6];
		e[0] = new General("General","Marry","Female","Taipei","20070325","2679-8811",35000,6);
		e[1] = new General("General","Will","Male  ","Kaohsiung","20100508","2785-8651",35000,0);
		e[2] = new SecondClassManager("SecondClassManager","Janey","Female","Taichung ","20090106","2769-7642",43000,10);
		e[3] = new SecondClassManager("SecondClassManager","Mark","Male  ","Hualien  ","20050419","2546-2314",45000,0);
		e[4] = new FirstClassManager("FirstClassManager","Sherry","Female","Taipei","19900625","2367-9887",52000,2);
		e[5] = new FirstClassManager("FirstClassManager","Patrick","Male","Tainan ","19920508","2699-4667",53000,0);
		
		for(int i=0;i<e.length;i++){
			System.out.print("½s¸¹ "+(i+1)+" ¸¹     ");
			e[i].printProfile();
			e[i].printSalary();
			System.out.println("----------------------------------------------------");
		}
	}//end of main
}//end of class EmployeeMain

