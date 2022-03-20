// Team Fried Chicken: Nina Jiang, Lea Kwok, Lindsay Phung
// APCS pd7
// L07: But These Go Up To Eleven
// 2022-03-19
// Time Spent: 2.0h

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */

	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] rank = {"2", "3", "6"};
		String[] suit = {"Diamonds", "Clubs", "Hearts"};
		int[] value = {1, 2, 3};

		String[] rank1 = {"5", "8", "4"};
		String[] suit1 = {"Apple", "Orange", "Pear"};
		int[] value1 = {43, 75, 27};

		String[] rank2 = {"2", "5", "9"};
		String[] suit2 = {"Popcorn", "Dorito", "Skittles"};
		int[] value2 = {3, 2, 8};

		Deck turtle = new Deck(rank, suit, value);
		Deck chicken = new Deck(rank1, suit1, value1);
		Deck bear = new Deck(rank2, suit2, value2);

		System.out.println(turtle);
		System.out.println(turtle.deal());

		System.out.println(chicken);
		System.out.println(chicken.deal());

		System.out.println(bear);
		System.out.println(bear.deal());
	}
}
