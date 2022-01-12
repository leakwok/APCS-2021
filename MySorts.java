/*
Un-UpTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd 7
HW54 -- One File to Bring Them All / summary of sort algorithms
2022-01-11
time spent: 00.2
*/

import java.util.ArrayList;

public class MySorts{
  /*
  ALGO:
    Make the number of elements - 1 passes.
    For each pass, starting at the end of the ArrayList, compare adjacent elements until the index of the number of passes you have made already.
    In each comparison, swap the elements if the one on the left is greater than the one on the right.
    Keep track of the number of swaps in each pass.
    If you reach the end of a pass and the number of swaps is 0, the ArrayList is sorted and you may stop the method.
    For the non-void method, make a deep copy of the ArrayList before performing the above steps and return the sorted version at the end.
  */
  public static void bubbleSort(ArrayList<Comparable> data){
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
        // if (swaps == 0){
            // return;
        // }
    }
  }
  /*
  ALGO:
    Start from the right end of the ArrayList and compare the elements in the ArrayList to find the greatest element.
    Keep track of the index of the greatest element in maxPos.
    Swap the element at maxPos with the element at the end of the window, which starts from the rightmost element on the first pass and shifts one element left with each pass.
    Repeat by starting at the next rightmost element and so on.
    There should be a total of n-1 passes for n elements.
    */
  public static void selectionSort(ArrayList<Comparable> data){
    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; pass > -1; pass--   ) {
      //System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
        maxPos = pass;
      for( int j = pass; j > -1; j--  ) {
        if(data.get(j).compareTo(data.get(maxPos)) > 0){
          maxPos = j;
        }
        //System.out.println( "maxPos: " + maxPos );//diag
        //System.out.println( data );//diag
      }
      data.set(pass, data.set( maxPos, data.get(pass) ) );
      //System.out.println( "after swap: " +  data );//diag
    }
  }
  /*
  ALGO:
   Keep track of a partition, which represents the index of what the sorted part goes up to.
   For elements up to and including the partiton, start from the right and compare the element with its left neighbor.
   If the left neighbor is greater than the element, then swap until the element of interest is greater than its left neighbor.
   Continue for the rest of the ArrayList until the partition reaches the number of elements in the ArrayList.
  */
  public static void insertionSort(ArrayList<Comparable> data){
    for( int partition = 1; partition < data.size() ; partition++) {
      //partition marks first item in unsorted region

      //System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      //System.out.println( data );

      //traverse sorted region from right to left
      for( int i = partition; i > 0; i-- ) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i-1).compareTo(data.get(i)) > 0 ) {
          //System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
          data.set(i-1, data.set( i, data.get(i-1) ) );
        }
        else
          break;
      }
    }
  }
}