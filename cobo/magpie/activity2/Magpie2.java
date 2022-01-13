// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW56 -- Turing Training Wheels
// 2022-01-12
// time spent: 01.1 hr
// collaborated with TDD in class

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */

 /*
 The highest recognized keyword in the if else statement ladder that appears in the String determines the response. You can prioritize responses by switching the order of the if-else statements.

 1. Even if the keyword is inside another word, it will still be treated as if the keyword is appearing in the String. The responses to these statements are irrelevant to what the person inputted because the keyword didn't actually appear as its own word.
 */
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.trim().length() == 0){
				response = "Say something, please.";
		}

		else if (statement.indexOf("Mykolyk") >= 0)
		{
			response = "He sounds like a good teacher.";
		}
		else if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >= 0
				)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("hi") >= 0
				|| statement.indexOf("hello") >= 0
				|| statement.indexOf("hey") >= 0
				)
		{
			response = "Nice to meet you.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Can you repeat that?";
		}
		else if (whichResponse == 5)
		{
			response = "I didn't quite get that.";
		}

		return response;
	}
}
