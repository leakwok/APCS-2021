/*
lourve -- Lea Kwok and Lindsay Phung
APCS
HW64 -- Revisitation / codingbat recursion-1 + recursion-2
time spent: 1 hr

Given an array of ints, is it possible to choose a group of some of the ints,
beginning at the start index, such that the group sums to the given target?
However, with the additional constraint that all 6's must be chosen. (No loops
needed.)

groupSum6(0, [5, 6, 2], 8) → true
groupSum6(0, [5, 6, 2], 9) → false
groupSum6(0, [5, 6, 2], 7) → false

WORK IN progress
*/

public class groupSum6 {

    public static boolean groupSum6(int start, int[] nums, int target) {
      if (start >= nums.length) {
        if (target == 0) {
          return true;
        }
        return false;
      }
      if (nums[start] != 6) {
        if (groupSum6(start + 1), nums, 6) == true) {
  
        }
      }
      else {
        if (groupSum6(start + 1, nums, target-nums[start]) == true) {
          return true;
        }
        if (groupSum6(start + 1, nums, target) == true) {
          return true;
        }
      }
      return false;
    }
  
    public static void main(String[] args) {
      int[] test = {2, 4, 8};
      System.out.println(groupSum6(0, test, 10));
      System.out.println(groupSum6(0, test, 14));
      System.out.println(groupSum6(0, test, 9));
    }
  
  }