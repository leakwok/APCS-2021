/*
Lea Kwok, Salaj Rijal
APCS
HW12 - Adding Instance Variables

*/

public class BigSib {
    public static void BigSib(){
       //setHelloMsg(message);
      // greet(name);
    }
    
    public String helloMsg;

    // setHelloMsg function: input string as greeting
    public void setHelloMsg(String helloMsg){
        this.helloMsg=helloMsg;
    }

    // greet function: combine greeting and name
    public String greet(String name){
        
        return(helloMsg + " "+ name);
    }   
    
}

/* 

DISCO
	you can name a variable outside of the method as long as it's in the class (thanks David)
    you must name a global variable because you can't call a variable local to a method

QCC
	what is richard?
    what is the purpose of richard?
    do i even need a BigSib() even if it's in Greet.java?

*/