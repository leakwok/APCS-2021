public class Loopier {



	public static void main(String args[]){
		int[] numbers = {4,7,2,4,6,8,12};
	
		randomArr(numbers);
		// System.out.println(numbers); prints out the address of the array instead of the values in the array
	
		for( int i : numbers){
			System.out.println(i);
		}
		
		// use a for loop to print the elements of the array (see ThinkJava)
	}


	// A static method to populate an existing array with randomly generated ints.
	public static void randomArr(int[] arr){
		for(int i : arr){
			i = (int)(Math.random()*10);
		}
	
	}


}







