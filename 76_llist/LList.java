/***
 *  * Unicorn Unicodes: Eric, Lea, Kosta
 * APCS
 * HW76 -- We Got a Little Ol' Convoy
 * 2022-03-15
 * time spent: 01.0 hours
 * KtS: 3
 * 
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList()
  {
    // YOUR CODE HERE
    _head = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    // YOUR CODE HERE
    LLNode temp = _head;
    
    temp.setNext(_head.getNext());
    temp.setCargo(newVal);
    
    _head = temp;

    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;

    for(int i = 0; i < index; i++) {
        temp = temp.getNext();
    }
    return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
    LLNode othTemp = _head;
    LLNode temp3 = _head;

    //find node to replace
    for(int i = 0; i < index-1; i++) {
        temp = temp.getNext();
    }

    //replace node
    temp.setCargo(newVal);

    //add prior nodes
/*     for(int j = index; j > 0; j--) {
        temp3.setCargo(othTemp.getCargo());
    } */
    
    temp.setNext(temp);

    //set _head
    _head = temp3;

    return newVal;
  }


  //return number of nodes in list
  public int size()
  {
    // YOUR CODE HERE
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    LLNode temp = _head;
    String res = "";
    while(temp != null) {
        res += temp + " ";
        temp = temp.getNext();
    }
    return res;
  }


  //main method for testing
  public static void main( String[] args )
  {
    
    LList james = new LList();
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("need");
    System.out.println( james );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println( "size: " + james.size() );
    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println( "2nd item is: " + james.get(1) );
    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList