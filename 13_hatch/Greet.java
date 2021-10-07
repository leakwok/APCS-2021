/*
Linuxers: Lea Kwok, Salaj Rijal (Gunter, George)
APCS
HW13 - Adding a Constructor

*/

/* 

DISCO
	you can put objects in a constructor

QCC
	was I supposed to put an object in the constructor?

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

