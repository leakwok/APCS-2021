/***
 *  * Unicorn Unicodes: Eric, Lea, Kosta
 * APCS
 * HW77 -- Insert|Remove
 * 2022-03-16
 * time spent: 02.0 hours
 * KtS: 2
 *
 * DISCO:
 * It's good to use temporary holders so the original _head isn't overwritten.
 *
 * QCC:
 * How does the set() in the closet work if _head isn't being set = to anything in the method? It still returns the correct DLLNode, which is interesting.
 * Is there a better way to store values instead of adding them one by one to another temporary holder?
 *
 * ALGO ADD:
 * if adding at index 0, use add(String)
 * else, iterate through temporary holder until you reach index
 * store these nodes
 * add String to remainder of temp
 * readd nodes in order
 *
 *
 * ALGO REM:
 * if removing the first node, set _head equal to CDR
 * else, start by storing the nodes up to and including the index to be removed (adding the CAR from temp into an LList holder and moving temp to the next node)
 * add prior nodes to index to a temporary holder
 * combine the two parts (part before the removed node and part after the removed node)
 *
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 **/

 /*****************************************************
  * class LList
  * Implements a linked list of DLLNodes, each containing String data
  * new in v2: add-at-index, remove
  *****************************************************/

  public class LList implements List //your List interface must be in same dir
  {
 
    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;
 
    // constructor -- initializes instance vars
    public LList( )
    {
      _head = null; //at birth, a list has no elements
      _tail = null;
      _size = 0;
    }
 
 
    //--------------v  List interface methods  v--------------
 
    public boolean add( String newVal )
    {
      DLLNode tmp = new DLLNode( newVal, _head );
      _head = tmp;
      _tail = tmp.getLast();
      _size++;
      return true;
    }
 
 
    public String get( int index )
    {
      if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();
 
      String retVal;
      DLLNode tmp = _head; //create alias to head
 
      //walk to desired node
      for( int i=0; i < index; i++ )
          tmp = tmp.getNext();
 
      //check target node's cargo hold
      retVal = tmp.getCargo();
      return retVal;
    }
 
 
    public String set( int index, String newVal )
    {
 
      if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();
 
      DLLNode tmp = _head; //create alias to head
 
      //walk to desired node
      for( int i=0; i < index; i++ )
          tmp = tmp.getNext();
 
      //store target node's cargo
      String oldVal = tmp.getCargo();
 
      //modify target node's cargo
      tmp.setCargo( newVal );
 
      return oldVal;
    }
 
 
    //return number of nodes in list
    public int size() { return _size; }
 
 
    //insert a node containing newVal at position index
    public void add( int index, String newVal ) {
 
      if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();
 
      DLLNode newNode = new DLLNode( newVal, null );
 
      //if index==0, insert node before head node
      if ( index == 0 )
          add( newVal );
      else {
          DLLNode tmp = _head; //create alias to head
 
          //walk to node before desired node
          for( int i=0; i < index-1; i++ )
          tmp = tmp.getNext();
 
          //insert new node
          newNode.setNext( tmp.getNext() );
          tmp.setNext( newNode );
 
          //increment size attribute
          _size++;
      }
    }
 
 
    //remove node at pos index, return its cargo
    public String remove( int index ) {
 
      if ( index < 0 || index >= size() )
          throw new IndexOutOfBoundsException();
 
      String retVal;
      DLLNode tmp = _head; //create alias to head
 
      //if index==0, remove head node
      if ( index == 0 ) {
          //check target node's cargo hold
          retVal = _head.getCargo();
 
          //remove target node
          _head = _head.getNext();
      }
      else {
          //walk to node before desired node
          for( int i=0; i < index-1; i++ )
          tmp = tmp.getNext();
 
          //check target node's cargo hold
          retVal = tmp.getNext().getCargo();
 
          //remove target node
          tmp.setNext( tmp.getNext().getNext() );
      }
 
      //decrement size attribute
      _size--;
 
      return retVal;
    }
 
    //--------------^  List interface methods  ^--------------
 
 
    // override inherited toString
    public String toString()
    {
      String retStr = "HEAD->";
      DLLNode tmp = _head; //init tr
      while( tmp != null ) {
          retStr += tmp.getCargo() + "->";
          tmp = tmp.getNext();
      }
      retStr += "NULL";
      return retStr;
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
      System.out.println( "size: " + james.size() );
 
      james.add("I");
      System.out.println( james );
      System.out.println( "size: " + james.size() );
 
      System.out.println( "2nd item is: " + james.get(1) );
 
      System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
      System.out.println( james );
 
      james.add(0,"whut");
      System.out.println( "...after add(0,whut): " );
      System.out.println( james );
 
      james.add(4,"phat");
      System.out.println( "...after add(4,phat): " );
      System.out.println( james );
 
      System.out.println( "...after remove last: "
                          + james.remove( james._size-1) );
      System.out.println( james );
 
      System.out.println( "...after remove(0): " + james.remove(0) );
      System.out.println( james );
 
      System.out.println( "...after remove(0): " + james.remove(0) );
      System.out.println( james );
 
      System.out.println( "...after remove(0): " + james.remove(0) );
      System.out.println( james );
    }
 
  }//end class LList