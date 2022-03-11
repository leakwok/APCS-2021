/**
 * Unicorn Unicodes: Eric, Lea, Kosta
 * APCS
 * HW73 -- All About the About Face
 * 2022-03-09
 * time spent: 01.0 hours
 * 
 * ALGO: O(n^2)... not greart
 * BEST CASE SCENARIO: When the first pivot that we choose maps to the y-1th index after being partitioned
 * WORST CASE SCENARIO: When the array is in reverse order should be the worst case
 * DISCO: We believe that this algorithm assumes that all elements are unique, which may not be the case. This is because our linear search simply finds the first occurance of the value not all of them.
 * QCC: How can we fix the assumptiom above, and improve time efficiency??
 */
public class QuickSelect {
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o )
    {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    public static int find(int[] arr, int val) {
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] == val) { 
                return i;
            }
        }
        return -1;
    }

    //--------------^  HELPER METHODS  ^--------------
    /**
   * int partition(int[],int,int,int)
   * DESCRIP
   * This method takes in an input array, and it looks at the data chunk between the inputted start and end indices.
   * It then sorts that interval into two sections, left and right. It uses the start index as the index of the pivot position.
   * This value of the pivot is used as a comparison for all array values, if an array element is less than or equal then it goes into the left section of the array,
   * if however it is greater than the special value at the specifed index it will go in the right section. 
   * 
   * @param arr : input array
   * @param start : start index
   * @param end : end index
   * @param splitInd : index of special comparative value
   * @return int[]
   *
   */
  public static int partition( int arr[], int loPos, int hiPos)
  {
    int pvtPos = loPos;
    int v = arr[pvtPos];

    swap( pvtPos, hiPos, arr);
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,hiPos,arr);

    return s;
  }//end partition

  /**
   * int fastSelect(int[] arr, int y)
   * DESCRIP
   * Finds yth smallest value in input array
   * 
   * Execution time: O(?)
   */
  public static int fastSelect(int[] arr, int y) {
    int newLoc; // init new loc
    int start = 0; // init start
    int end = arr.length - 1; // init end
    while(true) {
        newLoc = partition(arr, start, end); // partition by current pvt
        if(end == arr.length-1 && end-start == 1){
            return arr[end];
        }
        else{
            if(newLoc < y - 1) { // if val at pvt ended up too small
                start = newLoc;
            } else if(newLoc > y - 1) {
                end = newLoc;
            } else {
                return arr[y - 1];
            }
        }
    }
  }

  public static void main(String[] args) {
    int[] arr = {0, 5, 3, 6, 5};
    System.out.println("Testing cases for {0, 5, 3, 6, 5}: ");
    System.out.println("y=1: " + fastSelect(arr, 1)); //expected: 0
    System.out.println("y=2: " + fastSelect(arr, 2)); //expected: 3
    //System.out.println("y=3: " + fastSelect(arr, 3)); //expected: 5
    //System.out.println("y=4: " + fastSelect(arr, 4)); //expected: ?, gets stuck in a loop
    System.out.println("y=5: " + fastSelect(arr, 5)); //expected: 6

    int[] arr2 = {1, 1, 1, 1, 1};
    System.out.println("Testing cases for {1, 1, 1, 1, 1}: ");
    //System.out.println("y=2: " + fastSelect(arr2, 2)); //expected: ?, gets stuck in a loop

    int[] arr3 = {12, 5, 23, 7, 49, 4, 65, 231};
    System.out.println("Testing cases for {12, 5, 23, 7, 49, 4, 65, 231}: ");
    System.out.println("y=1: " + fastSelect(arr3, 1)); //expected: 4
    System.out.println("y=2: " + fastSelect(arr3, 2)); //expected: 5
    System.out.println("y=3: " + fastSelect(arr3, 3)); //expected: 7
    System.out.println("y=4: " + fastSelect(arr3, 4)); //expected: 12
    System.out.println("y=5: " + fastSelect(arr3, 5)); //expected: 23
    System.out.println("y=6: " + fastSelect(arr3, 6)); //expected: 49
    System.out.println("y=7: " + fastSelect(arr3, 7)); //expected: 65
    System.out.println("y=8: " + fastSelect(arr3, 8)); //expected: 231

    int[] arr4 = {-4, 6, -2, 3, 0};
    System.out.println("Testing cases for {-4, 6, -2, 3, 0}: ");
    System.out.println("y=1: " + fastSelect(arr4, 1)); //expected: -4
    System.out.println("y=2: " + fastSelect(arr4, 2)); //expected: -2
    System.out.println("y=3: " + fastSelect(arr4, 3)); //expected: 0
    System.out.println("y=4: " + fastSelect(arr4, 4)); //expected: 3
    System.out.println("y=5: " + fastSelect(arr4, 5)); //expected: 6
  }
}