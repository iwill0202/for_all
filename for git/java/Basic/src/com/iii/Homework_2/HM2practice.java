package com.iii.Homework_2;

public class HM2practice {
	/*static int generator(int gender){
		
		int sum=0, total=0, check=0, alpa=0;
		int midnum=0;
		for(int i=0;i<7;i++){//���ͤ����Ʀr
			midnum+=(int)(Math.random()*(9-0+1)+0)*(int)(Math.pow(10,i));
			
			sum+=(int)(Math.random()*(9-0+1)+0)*(i+1);	
		}
		//System.out.print(sum);
		total=sum+gender*8;
		return total;
	}//method generator*/
	
	static int generator(String sex,int place){
		int	gender=(sex.equals("�k"))? 1:2;
		int[] first={10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
		char[] abc={'A','B','C','D','E','F','G','J','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int sum=0, total=0,check,alpa=0;
		int midnum=0;
		for(int i=0;i<7;i++){//���ͤ����Ʀr
			midnum+=(int)(Math.random()*(9-0+1)+0)*(int)(Math.pow(10,i));
		}
		for(int j=0;j<7;j++){//���}�����Ʀr�A�A���P��Ӹ��X
			sum+=(midnum%(int)(Math.pow(10,j+1)))/(int)(Math.pow(10,j))*(j+1);
		}
		//System.out.print(sum);
		total=sum+gender*8;
		check=10-((first[alpa]/10)*1+(first[alpa]%10)*9+total)%10;
		if(check==10){
			check=0;
			System.out.println("�z�������� "+abc[alpa]+gender+midnum+check);
		}
		//System.out.println("check"+check);
		else{
			System.out.println("�z�������� "+abc[alpa]+gender+midnum+check);
		}
		return total;

	}//method gender
	
		public static void main(String[] args) {
			
			int alpa;
			String city = args[0];
			String sex = args[1];
			
			switch (city){
				case "�x�_��":
					alpa=0;
					generator(sex,alpa);break;
				
	
					
			
			
			
				default:break;
			}		
	}//main
}//class
		//if (args[0].equals("�k"))  //�P�_�k�k
		//	gender=1;
			
	//else(args[0].equals("�k")){
	//		gender=2;
	//}		