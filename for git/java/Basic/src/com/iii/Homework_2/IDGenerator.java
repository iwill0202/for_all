package com.iii.Homework_2;
public class IDGenerator {
	/*static int generator(int gender){
	
	int sum=0, total=0, check=0, alpa=0;
	int midnum=0;
	for(int i=0;i<7;i++){//產生中間數字
		midnum+=(int)(Math.random()*(9-0+1)+0)*(int)(Math.pow(10,i));
		
		sum+=(int)(Math.random()*(9-0+1)+0)*(i+1);	
	}
	//System.out.print(sum);
	total=sum+gender*8;
	return total;
}//method generator*/

	static int generator(String sex,int place){
		int	gender=(sex.equals("男"))? 1:2;
		int[] first={10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
		char[] abc={'A','B','C','D','E','F','G','J','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int sum=0, total=0,check,alpa=place;
		int midnum=0;
		for(int i=0;i<7;i++){//產生中間數字
			midnum+=(int)(Math.random()*(9-0+1)+0)*(int)(Math.pow(10,i));
		}
		for(int j=0;j<7;j++){//分開中間數字，再乘與對照號碼
			sum+=(midnum%(int)(Math.pow(10,j+1)))/(int)(Math.pow(10,j))*(j+1);
		}
		//System.out.print(sum);
		total=sum+gender*8;
		check=10-((first[alpa]/10)*1+(first[alpa]%10)*9+total)%10;
		if(check==10){
			check=0;
			System.out.println("您的身份證 "+abc[alpa]+gender+midnum+check);
		}
	//System.out.println("check"+check);
		else{
			System.out.println("您的身份證 "+abc[alpa]+gender+midnum+check);
		}
		return total;

}//method gender

		public static void main(String[] args) {
		
			int alpa;
			String city = args[0];
			String sex = args[1];
		
			switch (city){
			case "台北市":
				alpa=0;
				generator(sex,alpa);break;
			case "台中市":
				alpa=1;
				generator(sex,alpa);break;
			case "基隆市":
				alpa=2;
				generator(sex,alpa);break;
			case "台南市":
				alpa=3;
				generator(sex,alpa);break;
			case "高雄市":
				alpa=4;
				generator(sex,alpa);break;
			case "新北市":
				alpa=5;
				generator(sex,alpa);break;
			case "宜蘭縣":
				alpa=6;
				generator(sex,alpa);break;
			case "桃園縣":
				alpa=7;
				generator(sex,alpa);break;
			case "嘉義市":
				alpa=8;
				generator(sex,alpa);break;
			case "新竹縣":
				alpa=9;
				generator(sex,alpa);break;
			case "苗栗縣":
				alpa=10;
				generator(sex,alpa);break;
			case "台中縣":
				alpa=11;
				generator(sex,alpa);break;
			case "南投縣":
				alpa=12;
				generator(sex,alpa);break;
			case "彰化縣":
				alpa=13;
				generator(sex,alpa);break;
			case "新竹市":
				alpa=14;
				generator(sex,alpa);break;
			case "雲林縣":
				alpa=15;
				generator(sex,alpa);break;
			case "嘉義縣":
				alpa=16;
				generator(sex,alpa);break;
			case "台南縣":
				alpa=17;
				generator(sex,alpa);break;
			case "高雄縣":
				alpa=18;
				generator(sex,alpa);break;
			case "屏東縣":
				alpa=19;
				generator(sex,alpa);break;
			case "花蓮縣":
				alpa=20;
				generator(sex,alpa);break;
			case "台東縣":
				alpa=21;
				generator(sex,alpa);break;
			case "金門縣":
				alpa=22;
				generator(sex,alpa);break;
			case "澎湖縣":
				alpa=23;
				generator(sex,alpa);break;
			case "陽明山":
				alpa=24;
				generator(sex,alpa);break;
			case "連江縣":
				alpa=25;
				generator(sex,alpa);break;
			default:
				System.out.println("您輸入錯誤!");break;
		}		
}//main
}//class
	//if (args[0].equals("男"))  //判斷男女
	//	gender=1;
		
//else(args[0].equals("女")){
//		gender=2;
//}		