/* 
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW51 -- Dat Bubbly Tho
2022-01-03
time spent: 01.0 hour
*/

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO: 
    Make the number of elements - 1 passes. 
    For each pass, starting at the end of the ArrayList, compare adjacent elements until the index of the number of passes you have made already. 
    In each comparison, swap the elements if the one on the left is greater than the one on the right. 
    Keep track of the number of swaps in each pass. 
    If you reach the end of a pass and the number of swaps is 0, the ArrayList is sorted and you may stop the method.
    For the non-void method, make a deep copy of the ArrayList before performing the above steps and return the sorted version at the end.
 * 
 * DISCO:
 * Looking at the given implementation of populate(), we would have used a for loop to populate the Array instead of a while loop. We don't have much experience with while loops.
 * The last step of shuffle() works because .set() returns the previous element. So there is no need for a holder variable.
 * We implemented a counter and if statement to check if any more passes were necessary. We put in a print statement to check that we were doing the minimum number of passes.
 * We need to do a deep copy of the original ArrayList in bubbleSort() because we can't set the sorted ArrayList to the original because the original will have the same changes as the sorted one.
 * You can use a for each loop to make a copy of an ArrayList but you need a for loop for copying an Array because the index is important for Arrays. ArrayLists have the built in add() method.

 * QCC:
 * q0: If a pass requires no swaps, what do you know?
 * a0: The Array is sorted.
 * q1: After pass p, what do you know?
 * a1: The first p elements are in their final positions and you don't need to compare them again.
 * q2: How many passes are necessary to completely sort?
 * a2: The number of elements - 1 passes
 * We noticed that you have to make a deep copy for bubbleSort() instead of setting the sorted ArrayList to the original one, but we're not entirely sure why this happens.

 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
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
    //setup for traversal from right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    /* YOUR IMPLEMENTATION HERE */
    for(int i = 0; i < data.size() - 1; i++){
        int swaps = 0;
        for( int j = data.size()-1; j > i; j-- ) { 
            if ( data.get(j).compareTo(data.get(j-1)) < 0 ){
                // swap the positions
                data.set( j, data.set( j-1, data.get(j) ) );
                swaps += 1;
            }
        }
        // System.out.println("Number of swaps in this pass: " + swaps);
        if (swaps == 0){
            return;
        }
    }
  }

    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
        /* YOUR IMPLEMENTATION HERE */
        ArrayList inputCopy = new ArrayList<Comparable>();
        for( Comparable c : input){
            inputCopy.add(c);
        }

        bubbleSortV(inputCopy);

        return inputCopy;
    }

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
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList bob = new ArrayList<Integer>();
      bob.add(1);
      bob.add(3);
      bob.add(5);
      bob.add(12);
      bob.add(7);
      System.out.println( "ArrayList bob before sorting:\n" + bob );
      bubbleSortV(bob);
      System.out.println( "ArrayList bob after sorting:\n" + bob );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      //System.out.println( coco );
    /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class BubbleSort
