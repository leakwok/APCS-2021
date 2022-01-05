/* 
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW52 -- Selection, Natch
2022-01-05
time spent: 00.7 hour

Collaborated with TLP in class
*/

/******************************
 *   class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO: 
    Start from the right end of the ArrayList and compare the elements in the ArrayList to find the greatest element. 
    Keep track of the index of the greatest element in maxPos.
    Swap the element at maxPos with the element at the end of the window, which starts from the rightmost element on the first pass and shifts one element left with each pass.
    Repeat by starting at the next rightmost element and so on.
    There should be a total of n-1 passes for n elements.
 * 
 * DISCO
    We got thrown off by looking for the maximum instead of the minimum, which we were doing in class. When trying to fix our algorithm, we got confused, but it was helpful to comment everything out and rewrite it.
    Pass is equal to data.size()-1, not the actual number of passes.
    It seems like there is no way to "short circuit" and be certain there are no more swaps, unlike Bubble Sort. In Selection Sort, all cases take the same amount of time.
    We noticed there would be the same number of passes in the worst cases of Bubble Sort and Selection Sort. Each cases iterates through the same amount.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1 passes
 * q1: What do you know after pass p?
 * a1: The greatest p elements have been found and placed in their rightful position. There are p less elements to include in the next passes.
 * q2: How do you know if sorted?
 * a2: Completed n-1 passes on n elements
 * q3: What does a pass boil down to?
 * a3: Finding the greatest element within a window and swapping it with the element at the end of the window
 ******************************/

import java.util.ArrayList;

public class SelectionSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi )
  {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; pass > -1; pass--   ) {
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag

        maxPos = pass;
      
      for( int j = pass; j > -1; j--  ) {
        if(data.get(j).compareTo(data.get(maxPos)) > 0){
      		maxPos = j;
      	}
        
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag

      }

      data.set(pass, data.set( maxPos, data.get(pass) ) );
      System.out.println( "after swap: " +  data );//diag
    }

  }//end selectionSort

  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    selectionSortV( data );

    return data;
  }//end selectionSort

  public static void main( String [] args )
  {

    /*===============for VOID methods=============
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );

    ArrayList coco = populate( 10, 1, 1000 );
    System.out.println( "ArrayList coco before sorting:\n" + coco );
    selectionSortV(coco);
    System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

    /*==========for AL-returning methods==========
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
      ============================================*/

  }//end main

}//end class SelectionSort
