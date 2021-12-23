/*
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW49 - Rational Standards Compliance
2021-12-22
time spent: 01.0 hours
collab w/ Puntu in class

DISCO:
- Throwing an exception would be formatted as such (source: library): throw new ExceptionName(String optionalMessageToUser); In this way, using "new ExceptionName()" invokes the default constructor for the exception. Adding a String argument would invoke an overloaded constructor of the exception. Therefore, an exception is a class in Java (see our Q2).
- Having a Driver file is helpful in ensuring that our revisions to Rational are not working because of functionality specific to the Rational.java file.
QCC:
- One can typecast an Object into an instance of a certain class without writing code that dictates how the typecasting works. So, typecasting is a built-in ability of Java. (ex: (Rational) o).floatValue() typecasts Object o into a Rational. However, this example does rely on boolean short circuiting that ensures o is an instance of Rational. Also, even though boolean short circuiting confirms that o is an instance of Rational, without typecasting, there is a compile-time error.)
- Exceptions are classes in Java. Why? Is there no other way to write them/build them in?
- Comparable is a built in Java interface that only has one method. It's interesting that there's only one, yet a whole interface has been set aside to describe the property of having this one method.
- Should we throw an exception for equals() as we did for compareTo()? We assumed throwing wouldn't be necessary for equals(), since an input that is not a Rational would simply return false.
 */


public class Rational implements Comparable{
	private int numerator;
	private int denominator;

	public Rational (){
		numerator = 0;
		denominator = 1;
	}

	public Rational (int a, int b){
		this();
	        if(b == 0){
        		numerator = 0;
        		denominator = 1;
        		System.out.println("Invalid denominator. Rational has been set to 0/1.");
    	    	}
    		else{
		    numerator = a;
		    denominator = b;
    		}
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
    		if(s.numerator == 0){
        		System.out.println("Invalid operation for Rationals provided.");
    		}
    		else{
			numerator = this.numerator * s.denominator;
			denominator = this.denominator * s.numerator;
    		}
	}

  /* Takes 1 Rational object (just like multiply) and adds it to the current rational number object
   * Need not reduce
  */
  public void add(Rational r){
      this.numerator = this.numerator*r.denominator + r.numerator*this.denominator;
      this.denominator = this.denominator*r.denominator;
  }

  /* Works the same as add, except the operation is subtraction */
  public void subtract(Rational r){
    //r.numerator = -(r.numerator);
    //System.out.println(r.numerator);
    //this.add(r);
    this.numerator = this.numerator*r.denominator - r.numerator*this.denominator;
    this.denominator = this.denominator*r.denominator;
  }

  /* Returns the gcd fo the numerator and denominator of this Rational */
  public int gcd(){
      return gcd(this.numerator, this.denominator);
  }

  /* Returns the gcd of the two int parameters */
  public static int gcd(int a, int b){
      a = Math.abs(a);
      b = Math.abs(b);
      if(a == 0 || b == 0){
        return 1;
      }
      while(a != b){
    	if(a < b){
      	    b = b-a;
        }
        else{
      	    a = a-b;
        }
      }
      return a;
  }

  /* Changes this Rational to one in reduced form (should use gcd) */
  public void reduce(){
      int storeGCD = this.gcd();
      this.numerator = this.numerator/storeGCD;
      this.denominator = this.denominator/storeGCD;
  }

  /* Takes a Rational parameter and compares it to the calling object
   * Returns 0 if the two numbers are equal
   * Returns a positive integer if the calling number is larger than the parameter
   * Returns a negative integer if the calling number is smaller than the parameter */
  /*
  public int compareTo(Rational n){
        if(this.floatValue() == n.floatValue()){
            return 0;
        }
        else if(this.floatValue() < n.floatValue()){
            return -1;
        }
        else{
            return 1;
        }
  }
  */
  public int compareTo(Object o){
  	if(o instanceof Rational && ((Rational) o).floatValue() > this.floatValue()){
		return -1;
	}
	else if(o instanceof Rational && ((Rational) o).floatValue() == this.floatValue()){
		return 0;
	}
	else if(o instanceof Rational && ((Rational) o).floatValue() < this.floatValue()){
		return 1;
	}
	else{
		throw new ClassCastException("\ncompareTo() input not a Rational");
	}
  }

  public boolean equals(Object other){
  	if(other instanceof Rational && ((Rational) other).numerator == this.numerator && ((Rational) other).denominator == this.denominator){
		return true;
	}
	else{
		return false;
	}
  }
  public static void main(String[] args){
  	Rational r1 = new Rational();
  	Rational r2 = new Rational(50,3);
  	Rational r3 = new Rational(23,8);
          Rational r4 = new Rational(3, 0);
  	Rational r5 = new Rational(23, 8);

  	// test compareTo()
      	System.out.println(r1.compareTo(r2)); //expected: -1
      	System.out.println(r2.compareTo(r2)); //expected: 0
      	System.out.println(r2.compareTo(r3)); //expected: 1
  //	System.out.println(r3.compareTo("hello")); //expected: compareTo() input not a Rational
  //	System.out.println(r3.compareTo(23/8)); //expected: compareTo() input not a Rational

  	// test equals()
      	System.out.println(r1.equals(r2)); //expected: false
  	System.out.println(r2.equals(r2)); //expected: true
  	System.out.println(r3.equals("hello")); //expected: false
  	System.out.println(r3.equals(23/8)); //expected: false
  	System.out.println(r3.equals(r5)); //expected: true
  }
}