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

public class BigSib {
    
    private String helloMsg;
    
    // constructor
    public BigSib(String helloMsg){
        // same function as richard.setHelloMsg("Word up")
            // want to change the welcome message
        this.helloMsg = helloMsg;

    }

    // greet function: combine greeting and name
    public String greet(String name){
        
        return(helloMsg + " "+ name);
    } 

}