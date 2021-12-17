// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW48 -- Halving the Halves
// 2021-12-16
// time spent: 00.5 hours

/* 
DISCO:
- For the isSorted() method, you can't use a foreach loop because you need to access the previous element, and there is no way to do that with a foreach loop.
- You can use compareTo() for variable type Comparable since it's not a primitive. If the object it's being invoked on is greater than the argument, then compareTo() returns a number >0. If it is the opposite, it returns a number <0. If they are equal, then it returns 0.
- Our recursive and iterative method bodies were very similar. The iterative one returned m instead of the method because it is not recursive.

QCC:
- We used the provided tPos variable as the value to return if the target was not in the Array, however, the skeleton describes it as being the return variable, so should we update its value? How would that help?
- We had to be careful with using .equals() instead of == since we are not comparing primitives.
- The binSearch() helper method lets us test both implementations since we don't have to put in so many parameters. binSearch() helper allows the user to use binSearch without knowing if it's recursive or iterative. 
*/

/**
   class LinSearch
**/

public class LinSearch
{

  /**
     int linSearch(Comparable[],Comparable) -- searches an array of 
     Comparables for target
     post: returns index of first occurrence of target, or
     returns -1 if target not found
  **/
  public static int linSearch ( Comparable[] a, Comparable target )
  {
    int tPos = -1;
    int i = 0;

    while ( i < a.length ) {
	if(a[i].equals(target)){
		tPos = i;
		break;
	}
        i++;
	if(i == a.length){
		tPos = -1;
	}
    }
    return tPos;
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Object[] arr )
  {
    String output = "[ ";

    for( Object o : arr )
      output += o + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }


  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {

    System.out.println("\nNow testing linSearch on int array...");
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //Declare an array of Comparables and initialize it using ints
    //   Each int will be autoboxed to class Integer,
    //   which implements Comparable.
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );

    //search for 6 in array 
    System.out.println( linSearch(iArr,6) ); //should be 2

    //search for 43 in array 
    System.out.println( linSearch(iArr,43) ); //should be -1
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    System.out.println("\nNow testing linSearch on Comparable arrays...");


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing linSearch on String array...");

    //declare and initialize an array of Strings
    String[] sArr = { "kiwi", "watermelon", "orange", "apple", 
                      "peach", "watermelon" };
    printArray( sArr );

    //search for "watermelon" in array
    System.out.println( linSearch(sArr,"watermelon") ); //should be 1

    //search for "lychee" in array
    System.out.println( linSearch(sArr,"lychee") ); //should be -1
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*----------------------------------------------------

      ----------------------------------------------------*/

  }//end main()

}//end class LinSearch
