/* Team Fried Chicken :: Nina Jiang, Lea Kwok, Lindsay Phung
APCS
LAB09 -- Some Folks Call It A Charades / celeb lab
2022-04-27w
time spent: 2.0 hrs */

/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	private String _ans;
	private String _clu;

	/**
	 * The clue to determine the celebrity
	 */

	/**
	 * The answer or name of the celebrity.
	 */

	 public Celebrity() {
		 _ans = _clu = null;
	 }

	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
		_ans = answer;
		_clu = clue;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return _clu;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return _ans;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		_clu = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		_ans = answer;
	}

	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return _ans + " ";
	}

	public static void main(String[] args) {
		Celebrity celeb1 = new Celebrity("Tom Holland", "This person is the most recent Spiderman.");
		Celebrity celeb2 = new Celebrity();
		celeb2.setClue("This person was the lead in KC Undercover.");
		celeb2.setAnswer("Zendaya");
		System.out.println(celeb1);
		System.out.println(celeb2);
		System.out.println(celeb2.getClue());
		System.out.println(celeb2.getAnswer());
	}

}
