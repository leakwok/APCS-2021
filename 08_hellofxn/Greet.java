public class Greet {
	public static void main(String[] args) {
		greet("Sam");
		greet("Pear");
		greet("Syd");
	}
	
	public static void greet(String name){
		System.out.println("Hello " + name + "! How's your mom?");
	}
}

/* 

DISCOVERIES
	you can invoke one method rather than writing multiple System.out.println statements in the main method


UNRESOLVED QUESTIONS
	was running "java Greet" in terminal only supposed to produce one hello statement with a different/random name every time?

*/