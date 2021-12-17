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
   class BinSearch
   Binary search on array of Comparables
**/

public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of 
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( Comparable[] a, Comparable target )
  {
    //uncomment exactly 1 of the 2 stmts below:

    return binSearchIter( a, target, 0, a.length-1 );
    //return binSearchRec( a, target, 0, a.length-1 );
  }


  public static int binSearchRec( Comparable[] a,
                                  Comparable target,
                                  int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1

    int m = (lo + hi) / 2; //init mid pos var

    if(lo <= hi){

        if(a[m].equals(target)){
            return m;
        }
        else if(a[m].compareTo(target) > 0){
            hi = m-1;
            return binSearchRec(a, target, lo, hi);
        }
        else {
            lo = m+1;
            return binSearchRec(a, target, lo, hi);
        }
    }

    return tPos;
  }//end binSearchRec

    public static int binSearchIter( Comparable[] a,
                                    Comparable target,
                                    int lo, int hi )
    {

        int tPos = -1; //init return var to flag value -1
        int m = (lo + hi) / 2; //init mid pos var

        while(lo <= hi) { // run until lo & hi cross

            //update mid pos var
            m = (lo + hi) / 2;

            // target found
            if(a[m].equals(target)){
                return m;
            }

            // value at mid index higher than target
            else if(a[m].compareTo(target) > 0){
                hi = m-1;
            }

            // value at mid index lower than target
            else {
                lo = m+1;
            }

        }
        return tPos;
    }//end binSearchIter



  //tell whether an array is sorted in ascending order
  private static boolean isSorted( Comparable[] arr )
  {

    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here? A: You need to access the previous element, and there is no way to do that with a foreach loop.
    for( int i=0; i < arr.length-1; i++ ) {
      if ( ( arr[i].compareTo(arr[i+1]) > 0 ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Comparable[] arr ) {
    String output = "[ "; 

    for( Comparable c : arr )
	    output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }



  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {
 

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing binSearch on Comparable array...");

    //Declare and initialize array of Comparables
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) ); //expected: false

    Comparable[] iArr2 = { 2, 4, 6, 8, 13, 42 };
    printArray( iArr2 );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) ); //expected: true

    Comparable[] iArr3 = new Integer[10000];
    for( int i = 0; i < iArr3.length; i++ ) {
    iArr3[i] = i * 2;
    }

    //printArray( iArr3 );
    System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) );

    //search for 6 in array 
    System.out.println( binSearch(iArr2,2) ); //expected: 0
    System.out.println( binSearch(iArr2,4) ); //expected: 1
    System.out.println( binSearch(iArr2,6) ); //expected: 2
    System.out.println( binSearch(iArr2,8) ); //expected: 3
    System.out.println( binSearch(iArr2,13) ); //expected: 4
    System.out.println( binSearch(iArr2,42) ); //expected: 5

    //search for 43 in array 
    System.out.println( binSearch(iArr2,43) ); //expected: -1

    System.out.println( "now testing binSearch on iArr3..." );
    System.out.println( binSearch(iArr3,4) ); //expected: 2
    System.out.println( binSearch(iArr3,8) ); //expected: 4
    System.out.println( binSearch(iArr3,5) ); //expected: -1

    //search for 43 in array 
    System.out.println( binSearch(iArr3,43) ); //expected: -1
    /*----------------------------------------------------
    ====================================================*/


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class BinSearch2
