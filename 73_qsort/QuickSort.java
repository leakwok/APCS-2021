import javax.xml.transform.stax.StAXResult;

/***
 * Unicorn Unicodes: Eric, Lea, Kosta
 * APCS
 * HW73 -- All About the About Face
 * 2022-03-09
 * time spent: 01.0 hours

 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 *
 * 2a. Worst pivot choice and associated run time:
 *
 * 2b. Best pivot choice and associated run time:
 *
 * 3. Approach to handling duplicate values in array:
 *
 * 
 * QCC:
 * Lots of StackOverflowErrors when writing qsortHelper. Solved by trial and error and QAF comment by Team Watermelon but still unsure of how exactly code works.
 * Trials:
 * while(first != last)
 * if(first != last)
 **/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------




  /**
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    int start = 0;
    int end = d.length-1;
    
    /* int left = 0;
    int right = 0;
    int partLoc = QuickSelect.partition(d, 0, d.length-1);
    if(end - partLoc == 1){
      d[partLoc] = left;
      d[end] = right;
    }
    else{
      left = QuickSelect.partition(d, start, partLoc);
      right = QuickSelect.partition(d, partLoc, d.length-1);

    } */

    qsortHelper(d, start, end);

    /* //partition whole
    while(start != partLoc-1 && end != partLoc+1){
      if(start == partLoc){
        start++;
      }
      if(end == partLoc){
        end--;
      }
      //partition left
      QuickSelect.partition(d, start, partLoc-1);
      //partition right
      QuickSelect.partition(d, partLoc+1, end); */
    
  }

  //you may need a helper method...

  public static void qsortHelper(int[] d, int first, int last){
    
    int partLoc = QuickSelect.partition(d, first, d.length-1);
    if(first < last){
      qsortHelper(d, first, partLoc-1);
      qsortHelper(d, partLoc+1, last);
    }
  }
  


  //main method for testing
  public static void main( String[] args )
  {
      
      //get-it-up-and-running, static test case:
      int [] arr1 = {7,1,5,12,3};
      System.out.println("\narr1 init'd to: " );
      printArr(arr1);
      
      qsort( arr1 );
      System.out.println("arr1 after qsort: " );
      printArr(arr1);
      
      // randomly-generated arrays of n distinct vals
      int[] arrN = new int[10];
      for( int i = 0; i < arrN.length; i++ )
      arrN[i] = i;
      
      System.out.println("\narrN init'd to: " );
      printArr(arrN);
      
      shuffle(arrN);
      System.out.println("arrN post-shuffle: " );
      printArr(arrN);
      
      qsort( arrN );
      System.out.println("arrN after sort: " );
      printArr(arrN);
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      
      
      
      //get-it-up-and-running, static test case w/ dupes:
      int [] arr2 = {7,1,5,12,3,7};
      System.out.println("\narr2 init'd to: " );
      printArr(arr2);
      
      qsort( arr2 );
      System.out.println("arr2 after qsort: " );
      printArr(arr2);
      
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort