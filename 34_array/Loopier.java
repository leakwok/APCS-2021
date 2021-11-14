/* 
Un-up Town Leopard Rock
APCS
HW34-- A Pirate's Life for Me - Writing methods for Arrays
2021-11-14
time spent: 01.5 hours

DISCO:
- If we set an int equal to an integer greater than 2^31-1, it does not loop back to the negative numbers. int is set to 2^31-1, which is 2147483647.
- In our randomArr method, we had to use a regular for loop because the for each loop did not work in accessing and changing array elements, even though it works when printing them.
- System.out.println(numbers); prints out the address of the array instead of the values in the array if the toString method isn't overridden.

QCC:
- We used the ^ operator instead of Math.pow() and it seemed to work with two integers, but we weren't sure what it was doing. 2^33 outputted 35. 5^33 outputted 36. 2^32 outputted 34. 5^32 outputted 37. It seems like it outputs the same result every time, so it's not random. For some of the outputs, the result matches the sum of the two numbers, but not always, so we don't know what ^ actually does.
- Is there a built-in indexOf method for Arrays, like there is for Strings?
- Can we use our toString() method to perform linear search on the String rather than the Array? 
	if((int)(numbers.toString().substring(1, numbers.toString().indexOf(","))) == 4){
					System.out.println("It worked!");
				}
	It seems like we need a way to turn String into int or vice versa.

*/

public class Loopier {
	
	// A static method to populate an existing array with randomly generated ints.
	public static void randomArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(((Math.random()*2) - 1) * Math.pow(2,31));
		}
	}

	// A static method to return a String version of an array of ints.
	public static String toString(int[] arr){
		String result = "[";
		
		for( int i : arr){
			result += i + ", ";
		}
		result += "]";
		return result;
	}

	// Two public, static implementations of a linear search function that will return the index of the first occurrence of a target in an existing array, or -1 if not found.
		// first method iterates
			public static int linSearch( int[] a, int target ){
				for(int i = 0; i < a.length; i++){
					if(a[i] == target){
						return i;
					}
				}
				return -1;
			}

		// second method recurses
			public static int linSearchR( int[] a, int target ){
				return linSearchRHelper(a, target, 0);
				

			}

			// helper method
				public static int linSearchRHelper( int[] a, int target, int layer ){
					int[] newA = new int[a.length-1]; 

					if(a.length == 1 && a[0] != target){
						return -1;
					}

					if(a[0] == target){
						return layer;
					}
					else{
						for(int i = 1; i < a.length; i++){
							newA[i-1] = a[i];
						}
						return linSearchRHelper(newA, target, layer + 1);
					}


				}

	// Two public, static implementations of a frequency function that will return the number of occurrences of a target in an existing array.
		// first method iterates
			public static int freq( int[] a, int target ){
				int counter = 0;
				
				for(int i = 0; i < a.length; i++){
					if(a[i] == target){
						counter += 1;
					}
				}
				return counter;
			}


		// second method recurses
			public static int freqRec( int[] a, int target ){
				int[] newA = new int[a.length-1-linSearch(a,target)];

				if(linSearch(a,target) == -1){
					return 0;
				}

				if(linSearch(a, target) == a.length-1){
					return 1;
				}
				else {
						for(int i = 1 + linSearch(a,target); i < a.length; i++){
							newA[i-1-linSearch(a,target)] = a[i];
						}
						return 1 + freqRec(newA,target);
				}

			}


	public static void main(String args[]){
		int[] numbers = {4,7,2,4,6,8,12};
		

		// linSearch test
		System.out.println(linSearch(numbers, 8)); // expected: 5
		System.out.println(linSearch(numbers, 5)); // expected: -1 
		System.out.println(linSearch(numbers, 7)); // expected: 1

		// linSearchR test
		System.out.println(linSearchR(numbers, 8)); // expected: 5
		System.out.println(linSearchR(numbers, 5)); // expected: -1 
		System.out.println(linSearchR(numbers, 7)); // expected: 1
	
		int[] secondNum = {2,4,6,8,10,4,8,2};

		// freq test
		System.out.println(freq(secondNum,6)); // expected: 1
		System.out.println(freq(secondNum,8)); // expected: 2
		System.out.println(freq(secondNum,0)); // expected: 0

		// freqRec test
		System.out.println(freqRec(secondNum,6)); // expected: 1
		System.out.println(freqRec(secondNum,8)); // expected: 2
		System.out.println(freqRec(secondNum,0)); // expected: 0

		// randomArr test
		randomArr(numbers);

		// matching Array elements for toString() method
		for( int i : numbers){
			System.out.println(i);
		}

		// toString() test
		System.out.println(toString(numbers));
		
	}
}







