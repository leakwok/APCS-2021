/*
Lea Kwok, Max Schneider, David Chen (Gunter)
APCS
HW14 - Default Constructor vs Overload Constructor

*/

/* 

DISCO
	you can make an overloaded constructor or a default constructor
    the default constructor has no arguments

QCC
	how do you use a default constructor with the different greetings if no arguments are put in?

*/


public class Greet {
    public static void main(String[] args ) {
        String greeting;

        BigSib richard = new BigSib();
        BigSib grizz = new BigSib();
        BigSib dotCom = new BigSib();
        BigSib tracy = new BigSib();

        greeting = richard.greet("freshman");
        System.out.println(greeting);

        greeting = tracy.greet("Dr. Spaceman");
        System.out.println(greeting);

        greeting = grizz.greet("Kong Fooey");
        System.out.println(greeting);

        greeting = dotCom.greet("mom");
        System.out.println(greeting);
    }
}