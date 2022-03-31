/***
Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW85 -- Leon Leonwood Stack
2022-03-31
time spent: 00.7 hrs

 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    //Stack<String> cakes = new ALStack<String>();
    Stack<String> cakes = new LLStack<String>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //check empty, should be true
    System.out.println(cakes.isEmpty());

    //add to stack
    cakes.push("chocolate");
    cakes.push("strawberry");
    cakes.push("vanilla");
    cakes.push("funfetti");
    cakes.push("red velvet");
    cakes.push("matcha");


    //check if empty, expected: false
    System.out.println(cakes.isEmpty());

    //peek top, expected: matcha
    System.out.println(cakes.peekTop());

    //continue popping until empty
    while(!cakes.isEmpty()){
      System.out.println(cakes.pop());
    }

    //check if empty, expected: true
    System.out.println(cakes.isEmpty());

  }//end main

}//end class
