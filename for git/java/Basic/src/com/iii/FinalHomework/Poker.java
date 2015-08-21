package com.iii.FinalHomework;

public class Poker {

	public static void main(String[] args) {
		final int n=52;
		int[] card = new int[n+1];
		for(int i=0;i<=n;i++){//0,1~52==53
			card[i]=i;
		}
		for(int i=1;i<=n;i++){
			int j=(int)(Math.random()*(n-1+1)+1);
			//System.out.println(j);
			int mid=card[i];
			card[i]=card[j];
			card[j]=mid;			
		}
		for(int i=1;i<=n;i++){
			switch((card[i])%4){
			case 0:System.out.print("¶Â®ç");break;
			case 1:System.out.print("¬õ¤ß");break;
			case 2:System.out.print("¤è¶ô");break;
			case 3:System.out.print("±öªá");break;
			}
			int number=card[i]%13;
			switch(number){
			case 1:System.out.print("A\t");break;
			case 0:System.out.print("K\t");break;
			case 11:System.out.print("J\t");break;
			case 12:System.out.print("Q\t");break;
			default:System.out.print(number+"\t");break;
			}
			if(i%13==0){
				System.out.println("");
				System.out.println("----------------------------------------"
				+ "-------------------------------------------------------------");
			}
		}
		
	}
}
