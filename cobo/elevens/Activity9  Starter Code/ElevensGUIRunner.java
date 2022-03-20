// Team Fried Chicken: Nina Jiang, Lea Kwok, Lindsay Phung
// APCS pd7
// L07: But These Go Up To Eleven
// 2022-03-19
// Time Spent: 2.0h

/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new ElevensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
