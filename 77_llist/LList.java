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
 * How does the set() in the closet work if _head isn't being set = to anything in the method? It still returns the correct LLNode, which is interesting.
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
    LLNode temp = new LLNode(newVal, _head);
    _head = temp;
    _size++;
    return true;
  }

  public String remove( int index ){
    LLNode temp = _head;
    LLNode before = _head;
    LList holder = new LList();
    String removed = this.get(index);
    LLNode holdTemp;

    //set up before
    //before.setNext(null);

    if(index == 0) {
        _head = _head.getNext();
    }
    else{
        //find node to remove
        for(int i = 0; i <= index; i++) {
        //fill LList with nodes up to index
        holder.add(temp.getCargo()); 
        //go next node 
        temp = temp.getNext();
        }

        //before.setCargo(holder.get(index-1));

        //add prior nodes to index
        for(int j = 1; j <= index; j++) {
           /*  before.setNext(before);
            before.setCargo(holder.get(j));
            holdTemp = new LLNode(holder.get(j), before);
            System.out.println(holdTemp); 
            before = holdTemp; 
            System.out.println("we are setting this: " + before.getCargo());
            System.out.println("after setting next: " + before);
            System.out.println(before);  */

            /* System.out.println(temp);
            temp.setCargo(holder.get(j));
            System.out.println(temp); */
            before.setNext(new LLNode(holder.get(j) ,null));
            System.out.println(before);
        }
          
        //add two parts together
        before.setNext(temp);

        //set _head
        _head = before;
    }
    return removed; 
    
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
    LLNode before = _head;
    LList holder = new LList();

    //find node to replace
    for(int i = 0; i < index; i++) {
      //fill LList with nodes before index
      holder.add(temp.getCargo()); 
      //go next node 
      temp = temp.getNext();
    }

    //replace node at index
    temp.setCargo(newVal);

    //add prior nodes to index
    if(index != 0){
      for(int j = index; j > 0; j--) {
        before.setCargo(holder.get(j-1));
      }
    }
    
    //add two parts together
    before.setNext(temp);

    //set _head
    _head = before;

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
        res += temp.getCargo() + " ";
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
    System.out.println( "size: " + james.size() );
    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println( "2nd item is: " + james.get(1) );
    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );
    
    //TESTING REMOVE
    james.remove(2);
    System.out.println(james);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    james.remove(1);
    System.out.println(james);
    james.remove(2);
    System.out.println(james);
    james.remove(3);
    System.out.println(james);
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList