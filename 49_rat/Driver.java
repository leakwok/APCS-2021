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

public class Driver{
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