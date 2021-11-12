/*
Lea Kwok
APCS
HW28: PPMP - CodingBat String Problems
2021-11-01
time spent: 00.7
*/

/* Given a string, return a string where for every char in the original, there are two chars.
*/

public class doubleChar{
	public static String doubleChar(String str) {
		String a = "";
		
		for(int x = 0; x < str.length(); x++){
			
			a += str.substring(x,x+1) + str.substring(x,x+1);
			
		}
		return a;
	}
	
	public static void main(String args[]){
		System.out.println(doubleChar("The")); //expected: "TThhee"
        System.out.println(doubleChar("AAbb")); //expected: "AAAAbbbb"
        System.out.println(doubleChar("Hi-There")); //expected: "HHii--TThheerree"
	}
}