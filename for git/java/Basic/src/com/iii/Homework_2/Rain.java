package com.iii.Homework_2;
public class Rain{
	public static void main(String[] args) { //Integer.parseInt(args [0])
		double sum=0.0,avg=0.0;
		int i, j = 0,k;
		int[][][] threeDim=
						{{{323,361,120}, {364,254,162}, {236,254,219}, {369,384,280}},//0
			             {{167,252,381}, {236,174,257}, {354,345,309}, {224,157,108}},//1
			             {{302,380,220}, {391,376,371}, {188,285,229}, {283,265,356}},//2
			             {{259,393,271}, {386,320,216}, {348,363,308}, {399,151,381}},//3
			             {{269,303,298}, {113,208,306}, {102,397,192}, {159,179,270}}};//4
		if(args.length==0){
			for(i=0;i<5;i++)
				for(j=0;j<4;j++)
					for(k=0;k<3;k++)
						sum+=threeDim[i][j][k];
						avg=sum/60;
			System.out.print("5�~�`�����B�q�� "+avg+"mm");
				return;
		}
		
		if(args.length<=2&&(args[0].equals("year")||args[0].equals("month")||args[0].equals("season"))){//�~���
			if(args[0].equals("year")){//�~
				if(Integer.parseInt(args [1])>=1 &&Integer.parseInt(args [1])<=5){
					i=Integer.parseInt(args [1])-1;
					for(j=0;j<4;j++){
						for(k=0;k<3;k++)
						sum+=threeDim[i][j][k];
					}//for j
					avg=sum/12;
					System.out.println("��"+Integer.parseInt(args [1])+"�~�����B�q��"+Math.round(avg)+"mm");
				}
				else{
					System.out.print("�~��J���~�A�п�J1-5");
				}		
			}//�~
			if(args[0].equals("season")){
				if(Integer.parseInt(args [1])>=1 &&Integer.parseInt(args [1])<=4){
					for(i=0;i<5;i++){
						sum=0.0;
						j=Integer.parseInt(args [1])-1;
						for(k=0;k<3;k++)
							sum+=threeDim[i][j][k];	
							avg=sum/3;
							System.out.println("�� "+(i+1)+"�~�A�� "+Integer.parseInt(args [1])+"�u�����B�q�� "+Math.round(avg)+" mm");
					}
				}
				else{
					System.out.print("�u��J���~�A�п�J1-4");
				}	
			}
			if(args[0].equals("month")){
				if(Integer.parseInt(args [1])>=1&&Integer.parseInt(args [1])<=3){
					for(i=0;i<5;i++){
						j=0;
						k=Integer.parseInt(args [1])-1;
						System.out.println("�� "+(i+1)+"�~ "+Integer.parseInt(args [1])+"��B�q�� "+threeDim[i][j][k]+" mm");
					}//for i
				}//if ��1�uj=0
					
				if(Integer.parseInt(args [1])>=4&&Integer.parseInt(args [1])<=6){
					for(i=0;i<5;i++){
						j=1;
						k=Integer.parseInt(args [1])%3;
						System.out.println("�� "+(i+1)+"�~ "+Integer.parseInt(args [1])+"��B�q�� "+threeDim[i][j][k]+" mm");
					}//for i
				}//if ��2�uj=1
					
				if(Integer.parseInt(args [1])>=7&&Integer.parseInt(args [1])<=9){
					for(i=0;i<5;i++){
						j=2;
						k=Integer.parseInt(args [1])%3;
						System.out.println("�� "+(i+1)+"�~ "+Integer.parseInt(args [1])+"��B�q�� "+threeDim[i][j][k]+" mm");
					}// for i
				}//if ��3�uj=2
					
				if(Integer.parseInt(args [1])>=10&&Integer.parseInt(args [1])<=12){
					for(i=0;i<5;i++){
						j=3;
						k=Integer.parseInt(args [1])%3;
						System.out.println("�� "+(i+1)+"�~ "+Integer.parseInt(args [1])+"��B�q�� "+threeDim[i][j][k]+" mm");
					}// for i
				}//if ��4�uj=3
				else if(Integer.parseInt(args [1])>13){
					System.out.print("���J���~�A�п�J1-12");
				}
			}
		}//�~���end
		else {//if(args.length>3){
			System.out.print("��J���~");
		}
	}//main	
}//class