/* 
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW53 -- Poker Face
2022-01-06
time spent: 00.5 hour

Collaborated with TLP in class
*/

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
   Keep track of a partition, which represents the index of what the sorted part goes up to.
   For elements up to and including the partiton, start from the right and compare the element with its left neighbor.
   If the left neighbor is greater than the element, then swap until the element of interest is greater than its left neighbor.
   Continue for the rest of the ArrayList until the partition reaches the number of elements in the ArrayList.
 * 
 * DISCO
   We were able to complete this homework much faster because we spent a good amount of time tracing and planning in class. The previous homeworks also helped.
   We noticed similarities between different types of sorts. They all do n-1 passes, and in each pass, they iterate through the ArrayList again to sort elements.
   Having a partition is helpful to keep track of up to which elements we have already sorted through.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1 passes
 * q1: What do you know after pass p?
 * a1: The first p+1 elements are sorted up to the partition, but they are not necessarily in their final positions
 * q2: How will you know when sorted?
 * a2: When n-1 passes have been made and the partition is n
 * q3: What constitutes a pass?
 * a3: A pass constitutes walking down the leftmost unsorted element to its position in the sorted portion
 * q4: What must you track?
 * a4: Partition
   Why is there a second coco print statement at the end of the non void tests? Is that intentional?
 ******************************/

import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
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
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    for( int partition = 1; partition < data.size() ; partition++) {
      //partition marks first item in unsorted region

      System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      System.out.println( data );

      //traverse sorted region from right to left
      for( int i = partition; i > 0; i-- ) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i-1).compareTo(data.get(i)) > 0 ) {

          System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          data.set(i-1, data.set( i, data.get(i-1) ) );
        }
        else
          break;
      }
    }
  }//end insertionSortV

  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort

  public static void main( String [] args )
  {
    /*===============for VOID methods=============
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      ============================================*/

      System.out.println( "*** Testing non-void version... *** " );
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
    /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class InsertionSort

