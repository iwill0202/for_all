
public class EnumDemo1 {
	public enum Suit{CLUBS,DIAMONDS,HEARTS,SPADES}
	public static void main(String[] args){
		System.out.println("1.--"+Suit.CLUBS);
		System.out.println("2.--"+Suit.DIAMONDS.name());
		System.out.println("3.--"+Suit.HEARTS.ordinal());
		System.out.println("4.--"+Suit.SPADES.getDeclaringClass());
		System.out.println("5.--"+Suit.CLUBS.equals(Suit.DIAMONDS));
		Suit[] suit = Suit.values();
		for(Suit s :suit)
			System.out.println(s);
	}
}
