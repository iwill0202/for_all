package com.iii.Homework_2;
public class CheckID {
	static boolean check(int[] first,String id){
		int firstlater=id.charAt(0)-'A';
		int lastlater=10-((
				(first[firstlater]/10)*1+
				(first[firstlater]%10)*9+
				(id.charAt(1)-'0')*8+
				(id.charAt(2)-'0')*7+
				(id.charAt(3)-'0')*6+
				(id.charAt(4)-'0')*5+
				(id.charAt(5)-'0')*4+
				(id.charAt(6)-'0')*3+
				(id.charAt(7)-'0')*2+
				(id.charAt(8)-'0')*1)%10);
		int checkid=id.charAt(9)-'0';
		if(checkid==lastlater||checkid==lastlater-10){
			return true;
			//System.out.println("您的身份證字號"+id+"，是正確的。");
		}
		else{
			//System.out.print("你這個阿六仔");
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] first={10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};
		String id=args[0];//input ID
		
		id=id.toUpperCase();//all big
		id=id.trim();//delete space
		
		if(id.length()==10 && id.charAt(0)>='A'&& id.charAt(0)<='Z' ){
			if(id.charAt(1)=='1'||id.charAt(1)=='2'){//boy girl
				for(int i=2;i<=9;i++){
					//if(id.charAt(i)>='0' && id.charAt(i)<='9'){
					if(Character.isDigit(id.charAt(i))){
						if(check(first,id)){
							System.out.println("您的身份證字號"+id+"，是正確的。");
							break;
						}
						else{
							System.out.print("您的身份證字號 "+id+"，是錯誤的。你這個阿六仔。");
							break;
						}
					}
					else{System.out.print("2~9th num or not");
					}	
				}
			}//boy girl
			else{System.out.print("您的第二碼要為1或2");
			}
		}//length
		else{System.out.print("else length");
		}

	}//main
}//class