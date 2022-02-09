/*
Team Aloof: Brian Li, Lea Kwok; Turtles: Robert, Gunter
APCS pd07
HW61 -- Instructions so Simple...
2022-02-08
time spent: 1.0 hrs

DISCO:
- You can prevent OutOfBound errors by accounting for the indices that can potentially cause an error.
- We realized that the sort() method works recursively, so we used a base case of having 1 card, which
  would mean that array is sorted, and then created new arrays with each half of the inputted array,
  which we then repeated called merge() on after sorting each half.

QCC:
- What's the runtime complexity of Merge Sort?
*/

/***
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  Merge:
  - Add elements into one new, larger array from array a and b.
  - The element to be added is the lower value between the next index from a and b
    that is not already in the larger array.
  - If the end of array a or b has already been reached, add the remaining values from
    the other array into the larger array.

  Sort:
  - If the array is not of length 1, split the array in half and repeat this process.
  - If the array is of length 1, return the array and sort the array with its other half.

  ***/

  public class MergeSort
  {
    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    {
      int aCtr = 0, bCtr = 0;
      int[] merged = new int[a.length + b.length];
      for (int i = 0; i < merged.length; i++){
        if (aCtr >= a.length){ // all elements from a have been added already
          merged[i] = b[bCtr];
          bCtr += 1;
        }
        else if (bCtr >= b.length){ // all elements from b have been added already
          merged[i] = a[aCtr];
          aCtr += 1;
        }
        else {
          if (a[aCtr] > b[bCtr]){ // next val in a is greater than next val in b
            merged[i] = b[bCtr];
            bCtr += 1;
          }
          else { // next val in b is greater than or equal to next val in a
            merged[i] = a[aCtr];
            aCtr += 1;
          }
        }
      }
      return merged;
    }//end merge()
  
  
    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr )
    {
      // base case
      if (arr.length == 1){
        return arr;
      }
      // recursive reduction
      else {
        // split deck in half
        int[] arr_1 = new int[(int)(Math.floor(arr.length / 2.0))];
        for (int i = 0; i < arr_1.length; i++){
          arr_1[i] = arr[i];
        }
        int[] arr_2 = new int[(int)(Math.ceil(arr.length / 2.0))];
        for (int j = 0; j < arr_2.length; j++){
          arr_2[j] = arr[j + arr_1.length];
        }
  
        return merge(sort(arr_1), sort(arr_2));
      }
    }//end sort()
  
  
  
    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
      for( int i = 0 ; i<a.length; i++ )
        a[i] = 0;
    }
  
    //helper method for displaying an array
    public static void printArray( int[] a ) {
      System.out.print("[");
      for( int i : a )
        System.out.print( i + ",");
      System.out.println("]");
    }
    //---------------------------------------------------
  
  
    //main method for testing
    public static void main( String [] args )
    {
        int[] arr0 = {0};
        int[] arr1 = {1};
        int[] arr2 = {1,2};
        int[] arr3 = {3,4};
        int[] arr4 = {1,2,3,4};
        int[] arr5 = {4,3,2,1};
        int[] arr6 = {9,42,17,63,0,512,23};
        int[] arr7 = {9,42,17,63,0,9,512,23,9};
  
        System.out.println("\nTesting mess-with-array method...");
        printArray( arr3 );
        mess(arr3);
        printArray( arr3 );
  
        System.out.println("\nMerging arr1 and arr0: ");
        printArray( merge(arr1,arr0) );
  
        System.out.println("\nMerging arr4 and arr6: ");
        printArray( merge(arr4,sort(arr6)) );
  
        System.out.println("\nSorting arr4-7...");
        printArray( sort( arr4 ) );
        printArray( sort( arr5 ) );
        printArray( sort( arr6 ) );
        printArray( sort( arr7 ) );
        /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()
  
  }//end class MergeSort