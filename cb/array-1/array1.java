/* 
Un-up Town Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS
HW37 -- PPMP[] -- CodingBat Array-1
2021-11-16 
time spent: 00.7 hours
*/

public class array1{
	
	// Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
	public static boolean firstLast6(int[] nums) {
  		if(nums[0] == 6 || nums[nums.length-1] == 6){
  			return true;
  		}
  		return false;
	}	
	
	// Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.
	public static boolean sameFirstLast(int[] nums) {
  		if(nums.length >= 1 && nums[0] == nums[nums.length-1]){
  			return true;
  		}
  		return false;
	}
	
	// Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
	public static int[] makePi() {
		//int[] piArr = {3, 1, 4};
		return new int[] {3, 1, 4};	 
	}
	
	public static void main(String[] args){
		System.out.println("firstLast6 tests:");
		int[] arr0 = {1, 2, 6};
		System.out.println(firstLast6(arr0)); // expected: true
		int[] arr1 = {6, 1, 2, 3};
		System.out.println(firstLast6(arr1)); // expected: true
		int[] arr2 = {13, 6, 1, 2, 3};
		System.out.println(firstLast6(arr2)); //expected: false
		
		System.out.println("\nsameFirstLast tests:");
		int[] arr3 = {1, 2, 6};
		System.out.println(sameFirstLast(arr3)); //expected: false
		int[] arr4 = {1, 2, 3, 1};
		System.out.println(sameFirstLast(arr4)); //expected: true
		int[] arr5 = {1, 2, 1};
		System.out.println(sameFirstLast(arr5)); //expected: true
		
		System.out.println("\nmakePi tests:");
		for(int i : makePi()){
			System.out.println(i);
		}
	}



}
