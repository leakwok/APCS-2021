/***
 * Unicorn Unicodes: Eric, Lea, Kosta
 * APCS
 * HW78 -- Double Up
 * 2022-03-17
 * time spent: 01.5 hours
 * KtS: 2
 *
 * DISCO:
 * Creating two CDRs is a smart way to point in two different directions.
 *
 * QCC:
 * Does the tail pointer point to the last node or the left CDR of the first node?
 * Would the left CDR of the first node point back to the last node then?
 * And would the right CDR of the last node point to the first node?
 *
 * ALGO ADD:
 * create new node with value being added
 * set _head equal to new node
 * set _tail equal to left most CDR
 * update size
 *
 * ALGO REM:
 * if removing the first node, set _head equal to CDR
 * else, walk to node right before index to be removed
 * get value of node after index and set temp to that node
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