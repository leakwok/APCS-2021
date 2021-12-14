/* 
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW41 -- Be Rational
2021-12-01
time spent: 00.6 hour

DISCO:
- If you have a method that returns a float and you attempt to return a value that is an int, the method will typecast that value into a float after all operations have been performed on it. For example, in floatValue() if you attempt to return the numerator divided by the denominator, it would treat the operation as integer division, and would only return a floating point that is equivalent to the quotient of the integer division. However, if you typecast either the numerator or the denominator, the operation would no longer be integer division, and you would get a value returned that is the typecasted type.
- UML diagrams are helpful!
- A default constructor still needs parentheses. This is easy to forget since you don't need to include them when declaring a class.

QCC:
- Do we have to use the this keyword when referring to the current instance of the class? What would be the benefit of using the this keyword over referring directly to the instance variable? For example, numerator = this.numerator * s.numerator; vs numerator = numerator * s.numerator; both seem to work as expected, so we're not sure what the difference is.
- To implement in the future: + void reciprocal() for taking the reciprocal of a Rational number, + void add(Rational) and + void subtract(Rational) are hard to implement because you have to find the least common multiple of the denominators, at least in the typical human way of calculating.
- Does Java have a built-in Rational data type? Why are floating points and integers primitives but Rationals aren't?

 */


public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational (){
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

	/* returns floating point approximation of the number
	uses the most precise floating point primitive */
	public float floatValue(){
		return ((float) numerator) / denominator;
	}
	
	/* takes 1 Rational object as a parameter and multiplies it by this Rational object
	does not return any value
	should modify this object and leave the parameter alone (see below for example)
	need not reduce the fraction */
	public void multiply(Rational s) {
		numerator = this.numerator * s.numerator;
		denominator = this.denominator * s.denominator;
	}

	/* works the same as multiply, except the operation is division */
	public void divide(Rational s){
		numerator = this.numerator * s.denominator;
		denominator = this.denominator * s.numerator;
	}

	public static void main(String[] args){
		Rational r1 = new Rational();
		Rational r2 = new Rational(7,3);
		Rational r3 = new Rational(23,8);

		// test toString()
		System.out.println(r1); //expected: 0/1
		System.out.println(r2); //expected: 7/3

		// test floatValue()
		System.out.println(r1.floatValue()); //expected: 0.0
		System.out.println(r2.floatValue()); //expected: 2.3333333
		
		// test multiply()
		r1.multiply(r2);
		r2.multiply(r3);
		System.out.println(r1); //expected: 0/3
		System.out.println(r2); //expected: 161/24
		System.out.println(r3); //expected: 23/8
 
		// test divide()
		r1.divide(r2);
		r2.divide(r3);
		System.out.println(r1); //expected: 0/483
		System.out.println(r2); //expected: 1288/552
		System.out.println(r3); //expected: 23/8
	
	}
	
	
}
