/**
 * Unicorn Unicodes: Eric, Lea, Kosta
 * APCS
 * HW78 -- Double Up
 * 2022-03-17
 * time spent: 01.5 hours
 * KtS: 2

 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode
{
  //instance vars
  private String _cargo;
  private DLLNode _rightNode;
  private DLLNode _leftNode = null;

  // constructor
  public DLLNode( String value, DLLNode right)
  {
    _cargo = value;
    _rightNode = right;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _rightNode;
  }

  public DLLNode getLast()
  {
      return _leftNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _rightNode = newNext;
    return foo;
  }

  public DLLNode setLast(DLLNode newLast){
    /* DLLNode foo = getLast();
    _leftNode = newLast; */
    
    DLLNode foo = getNext();
    foo._leftNode = newLast;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _cargo;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode first = new DLLNode( "cat", null);

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null ) );

    //change first node
    System.out.println(first.getNext().getLast());
    

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null ) );

    while( first != null ) {
        System.out.println( first );
        first = first.getNext();
    }
    /* A naive list traversal, has side effects.... ??
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: It can't go back to the node it left because when it goes to the next node, the CAR becomes the String of that new node, and the old CAR and node are lost.

    /* trace:
         *
        / \
      cat  *
          / \
        dog  *
            / \
          cow  *
     
    */

    //...so better: ?
    // Create an way to "save" each node so that going back is possible?
    //
    //

  }//end main

}//end class DLLNode