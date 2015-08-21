package com.iii.Homework_1;
public class Loan {
	public static void main(String[] args) {
		int year, money=100000;
		double tb=0,td=0,tu=0;
		double bankm=0.2/12, downm=0.1, underm=0.01*30;
		for(year=1;year<=12;year++){
			tb=money*(1+bankm*year);
			td=money*(1+downm*year);
			tu=money*(1+underm*year);
		System.out.print("第 "+year+"月"+"，需還銀行  "+Math.round(tb)+"元");
		System.out.print("、當鋪  "+Math.round(td)+"元");
		System.out.println("和 地下錢莊  "+Math.round(tu)+"元");
		}//for
			
	}//main
}//class
//錢不精以100000元分別向銀行、當鋪和地下錢莊借貸。
//若銀行的年利率為20%，當鋪月利率為10%和地下錢莊日利率為1%。
//以月為單位，計算一個月後至一年後每個月該歸還多少錢。