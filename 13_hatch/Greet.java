/*
Linuxers: Lea Kwok, Salaj Rijal (Gunter, George)
APCS
HW13 - Adding a Constructor

*/

/* 

DISCO
	you can name a variable outside of the method as long as it's in the class (thanks David)
    you must name a global variable because you can't call a variable local to a method

QCC
	what is richard?
    what is the purpose of richard?
    do i even need a BigSib() even if it's in Greet.java?

*/

public class Greet {
  public static void main( String[] args ) {
    String greeting;

    BigSib richard = new BigSib("Word up");
    // richard.BigSib("Word up");
    // richard.setHelloMsg("Word up");

    greeting = richard.greet("freshman");
    System.out.println(greeting);

  } //end main()
} //end Greet

