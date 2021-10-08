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

public class BigSib{
    private String helloMsg;

    // constructor
    public BigSib(String helloMsg){
        this.helloMsg = helloMsg;

    }

    public String greet(String name){
        return(helloMsg + " " + name);
    }

}