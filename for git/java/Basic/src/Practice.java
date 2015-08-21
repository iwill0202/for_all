
public class Practice {

	public static void main(String[] args) {
		int coverage=200, area=300, count;
		count=area/coverage;
		count+=(area%coverage==0)?0:1;
		String X=(count==1)?"can":"cans";
		System.out.println("Need "+count+" "+X+" to paint.");
	}//main()
}//class()