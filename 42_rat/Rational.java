/*
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW42 -- Be More Rational
2021-12-04
time spent: 01.2 hours

DISCO:
- A method can return a non-primitive instance of a class (the return type does not have to be something already built into Java). For example, it would be possible to return a Rational, and the returned value could also be checked since we have a toString() method.
- When you call a method from an instance of a class using the dot operator, the argument of the method can be the same instance that you are calling the method from. For example, it is possible to run r2.compareTo(r2).
- Much like default and overloaded constructors, methods in Java may have the same name but take different parameters. For example, the two gcd() methods we have in Rational are different because one is static and takes two parameters while the other is non-static and doesn't take parameters.

QCC:
- We used our gcd() method from Stats.java of HW26 (which uses a while loop). However, we needed to set the parameters to their absolute values so that the method could handle negative numbers. We also incorporated an if statement to catch cases with either parameter being 0.
- We used the static gcd() method in the non-static gcd() method.
- Why doesn't our implementation of subtract() using add() work as expected? We printed out the numerator of the parameter to confirm that the numerator is indeed being negated, so we're not sure what the issue is. The denominator of the difference also appears to match its expected value.
    r.numerator = -(r.numerator);
    System.out.println(r.numerator);
    this.add(r);
 */


public class Rational {
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

	public static void main(String[] args){
		Rational r1 = new Rational();
		Rational r2 = new Rational(7,3);
		Rational r3 = new Rational(23,8);
    Rational r4 = new Rational(3, 0);

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
    r3.divide(r4);
    System.out.println(r3); //expected: Invalid operation for Rationals provided. /n 23/8

    // test compareTo()
    System.out.println(r1.compareTo(r2)); //expected: -1
    System.out.println(r2.compareTo(r2)); //expected: 0
    System.out.println(r2.compareTo(r3)); //expected: 1

    // test static gcd()
    System.out.println(gcd(3, 3)); //expected: 3
    System.out.println(gcd(9, 15)); //expected: 3
    System.out.println(gcd(15, 18)); //expected: 3
    System.out.println(gcd(3, 14)); //expected: 1
    System.out.println(gcd(16, 28)); //expected: 4
    System.out.println(gcd(1, 40)); //expected: 1
    System.out.println(gcd(20, 12)); //expected: 4
    System.out.println(gcd(-20, -12)); //expected: 4
    System.out.println(gcd(0, 20)); //expected: 1

    //test non-static gcd()
    System.out.println(r1.gcd()); //expected: 1
    System.out.println(r2.gcd()); //expected: 184
    System.out.println(r3.gcd()); // expected: 1
    System.out.println(r4.gcd()); // expected: 1

    //test add()
    r1.add(r2);
    r2.add(r3);
    r3.add(r4);
    r4.add(r1);
    System.out.println(r1); // expected: 622104/266616
    System.out.println(r2); // expected: 23000/4416
    System.out.println(r3); // expected: 23/8
    System.out.println(r4); // expected: 622104/266616

    //test subtract()
    r1 = new Rational(1, 5);
    r2 = new Rational(-2, 8);
    r3 = new Rational(6, 7);
    r4 = new Rational(0, 5);
    r1.subtract(r2);
    r2.subtract(r3);
    r3.subtract(r4);
    r4.subtract(r1);
    System.out.println(r1); // expected: 18/40
    System.out.println(r2); // expected: -62/56
    System.out.println(r3); // expected: 30/35
    System.out.println(r4); // expected: -90/200

    //test reduce()
    r1.reduce();
    r2.reduce();
    r3.reduce();
    r4.reduce();
    System.out.println(r1); // expected: 9/20
    System.out.println(r2); // expected: -31/28
    System.out.println(r3); // expected: 6/7
    System.out.println(r4); // expected: -9/20

    //exempli gratia
    Rational r = new Rational(2,3); //Stores the rational number 2/3
    Rational s = new Rational(1,2); //Stores the rational number 1/2
    Rational t = new Rational(4,18); //Stores the rational number 4/18
    r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
    t.reduce(); //Changes t to 2/9
    System.out.println(r); //expected: 7/6
    System.out.println(s); //expected: 1/2
    System.out.println(t); //expected: 2/9
	}


}