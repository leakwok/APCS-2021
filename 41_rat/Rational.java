public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational(){
		numerator = 0;
		denominator = 1;		
	}
	
	public Rational (int a, int b){
		numerator = a;
		denominator = b;
	}
	
	public String toString(){
		return numerator + "/" + denominator;
	}
	
	public static void main(String[] args){
		Rational r1 = new Rational();
		Rational r2 = new Rational(7,3);
		
		// test toString()
		System.out.println(r1);
		System.out.println(r2);
		
	
	}
	
	
}
