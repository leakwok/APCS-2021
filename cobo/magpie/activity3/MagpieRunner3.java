// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW56 -- Turing Training Wheels
// 2022-01-12
// time spent: 01.1 hr
// collaborated with TDD in class

import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner3
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Magpie3 maggie = new Magpie3();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}

		//System.out.println(findKeyword("She's my sister", "sister", 0));
		/*
		Trace:
		Iteration		psn		before		after
		1				9		" "			" "
		*/

		//System.out.println(findKeyword("Brother Tom is helpful", "brother", 0));
		/*
		Trace:
		Iteration		psn		before		after
		1				0		" "			" "
		*/

		//System.out.println(findKeyword("I can't catch wild cats.", "cat", 0));
		/*
		Trace:
		Iteration		psn		before		after
		1				8		" "			"c"
		2				19		" "			"s"
		3				-1		" "			"s"
		*/

		//System.out.println(findKeyword("I know nothing about snow plows.", "no", 0));
		/*
		Trace:
		Iteration		psn		before		after
		1				3		"k"			"w"
		2				7		" "			"t"
		3				22		"s"			"w"
		4				-1		"s"			"w"
		*/
	}

}
