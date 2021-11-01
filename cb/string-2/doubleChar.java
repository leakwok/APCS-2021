/* Given a string, return a string where for every char in the original, there are two chars.
*/

public class doubleChar{
	public static String doubleChar(String str) {
		String a;
		for(int x = 0; x < str.length(); x++){
			
			a += str.substring(x) + str.substring(x);
			
		}
		return a;
	}
	
	public static void main(String args[]){
		System.out.println(doubleChar("The")); // "TThhee"
        System.out.println(doubleChar("AAbb")); // "AAAAbbbb"
        System.out.println(doubleChar("Hi-There")); // "HHii--TThheerree"
	}
}