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

public class LLStack<PANCAKE> implements Stack<PANCAKE>
{
  private LinkedList<PANCAKE> _stack;
  private int _stackSize;


  //constructor
  public LLStack()
  {
    _stack = new LinkedList<PANCAKE>();
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
    if ( isEmpty() )  return retStr;
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
    

  }//end main()

}//end class Latkes