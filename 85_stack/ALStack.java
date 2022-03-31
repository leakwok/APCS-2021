/***
Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW85 -- Leon Leonwood Stack
2022-03-31
time spent: 00.7 hrs

 * class Latkes
 * v1
 * Implements a stack of Strings using an encapsulated array
 **/

 import java.util.*;

public class ALStack<PANCAKE> implements Stack<PANCAKE>
{
  private ArrayList<PANCAKE> _stack;
  private int _stackSize;


  //constructor
  public ALStack()
  {
    _stack = new ArrayList<PANCAKE>();
    _stackSize = 0;
  }


  //means of insertion
  public void push( PANCAKE s )
  {
    _stack.add(s);
    _stackSize++;
  }


  //means of removal
  public PANCAKE pop()
  {
    PANCAKE retStr = null;
    if ( isEmpty() )  return null;
    retStr = _stack.remove(_stackSize-1);
    _stackSize--;
    return retStr;
  }

  public PANCAKE peekTop() {
    return _stack.get(_stackSize - 1);
  }


  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }

  //chk for fullness
  public boolean isFull()
  {
    return _stackSize >= _stack.size();
  }


  //main method for testing
  public static void main( String[] args )
  {
    ALStack<String> tastyStack = new ALStack<String>();

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    //cachoo
    System.out.println( tastyStack.pop() );
    //coocoo
    System.out.println( tastyStack.pop() );
    //joo
    System.out.println( tastyStack.pop() );
    //ioo
    System.out.println( tastyStack.pop() );
    //hoo
    System.out.println( tastyStack.pop() );
    //goo
    System.out.println( tastyStack.pop() );
    //foo
    System.out.println( tastyStack.pop() );
    //eoo
    System.out.println( tastyStack.pop() );
    //doo
    System.out.println( tastyStack.pop() );
    //coo
    System.out.println( tastyStack.pop() );
    //boo
    System.out.println( tastyStack.pop() );
    //aoo
    System.out.println( tastyStack.pop() );

    //stack empty by now; SOP(null)
    System.out.println( tastyStack.pop() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes