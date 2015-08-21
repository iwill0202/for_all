public class ThreeOperator {

	public static void main(String[] args) {
		int coverage = 200, area = 201, count;
		count = area / coverage;
		count += (area % coverage == 0) ? 0 : 1;
		String s = (count == 1) ? "can" : "cans";
		System.out.println("Need " + count + " " + s + " to paint");
	}

}
