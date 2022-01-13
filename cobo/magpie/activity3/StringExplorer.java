// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW56 -- Turing Training Wheels
// 2022-01-12
// time spent: 01.1 hr
// collaborated with TDD in class

/**
 * A program to allow students to try out different
 * String methods.
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";

		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);

		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

		//  Try other methods here:
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexof(\"slow\") = " + notFoundPsn);

		int notFoundPsn2 = sample.indexOf("watermelon", 2);
		System.out.println("sample.indexof(\"watermelon\") = " + notFoundPsn2);

		int notFoundPsn3 = sample.indexOf("quick", 10);
		System.out.println ("sample.indexOf(\"quick\") = " + notFoundPsn3);
	}
}
