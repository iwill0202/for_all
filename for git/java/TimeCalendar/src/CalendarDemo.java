import java.text.SimpleDateFormat;
import java.util.*;


public class CalendarDemo {

	public static void main(String[] args) {
		String[] week={"Sunday","Monday","Tuesday","Wednesday","Thusday","Friday","Saturday"};
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day =  today.get(Calendar.DATE);
		int dayofWeek = today.get(Calendar.DAY_OF_WEEK);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int minute =  today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		System.out.print("Today is "+year+"/"+month+"/"+day);
		System.out.println("  "+week[(dayofWeek-1)]);
		System.out.println("Time is "+hour+":"+minute+":"+second);
		//SimpleDateFormat dd=new SimpleDateFormat("MM");
		String a=String.format("%02d",0);
		System.out.println(a);
		
	}
}
