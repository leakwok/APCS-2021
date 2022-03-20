// Team Fried Chicken: Nina Jiang, Lea Kwok, Lindsay Phung
// APCS pd7
// L07: But These Go Up To Eleven
// 2022-03-19
// Time Spent: 2.0h

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card turtle = new Card("3", "Hearts", 3);
		Card chicken = new Card("9", "Spades", 9);
		Card bear = new Card("5", "Diamonds", 5);

		System.out.println(turtle.matches(turtle));
		System.out.println(bear.matches(turtle));
	}
}
