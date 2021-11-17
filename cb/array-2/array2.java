/* 
Un-up Town Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
HW37 -- PPMP[] -- CodingBat Array-2
2021-11-16 
time spent: 00.7 hours
*/

public class array2{
    // Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
    public static int countEvens(int[] nums) {
        int counter = 0;
        for( int i : nums){
            if(i % 2 == 0){
                counter += 1;
            }
        }
        return counter;
    }

    // Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
    public static int bigDiff(int[] nums) {
        int largest = nums[0];
        int smallest = nums[0];
        
        for( int i : nums){
            largest = Math.max(largest, i);
             smallest = Math.min(smallest, i);
        }
        return largest - smallest;
        
    }

    // Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
    public static int centeredAverage(int[] nums) {
        int largest = nums[0];
        int smallest = nums[0];
        int sum = 0;

        for( int i : nums){
            largest = Math.max(largest, i);
            smallest = Math.min(smallest, i);
            sum += i;
        }

        return (sum - largest - smallest) / (nums.length - 2);
    }

    public static void main(String[] args){
        System.out.println("countEvens tests:");
        System.out.println(countEvens(new int[] {2, 1, 2, 3, 4})); //expected: 3
        System.out.println(countEvens(new int[] {2, 2, 0})); //expected: 3
        System.out.println(countEvens(new int[] {1, 3, 5})); //expected: 0

        System.out.println("\nbigDiff tests:");
        System.out.println(bigDiff( new int[] {10, 3, 5, 6})); //expected: 7
        System.out.println(bigDiff( new int[] {7, 2, 10, 9})); //expected: 8
        System.out.println(bigDiff( new int[] {2, 10, 7, 2})); //expected: 8

        System.out.println("\ncenteredAverage tests:");
        System.out.println(centeredAverage( new int[] {1, 2, 3, 4, 100})); //expected: 3
        System.out.println(centeredAverage( new int[] {1, 1, 5, 5, 10, 8, 7})); //expected: 5
        System.out.println(centeredAverage( new int[] {-10, -4, -2, -4, -2, 0})); //expected: -3
    }

}