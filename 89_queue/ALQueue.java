import java.util.ArrayList;

/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class ALQueue<QUASAR> implements Queue<QUASAR>
{
  //instance variables
  private ArrayList<QUASAR> _list;


  // default constructor creates an empty queue
  public ALQueue()
  {
    _list = new ArrayList<QUASAR>();
  }


  public void enqueue( QUASAR enQVal )
  {
    // does adding to the end of the list mean putting it in the first possible empty position?
    _list.add(enQVal);
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public QUASAR dequeue()
  {
    QUASAR tmp = _list.get(0);
    _list.remove(0);
    return tmp;
  }//O(n)


  public QUASAR peekFront()
  {
    return _list.get(0);
  }//O(1)


  public boolean isEmpty()
  {
    return (_list.size() == 0);
  } //O(1)


  // print each node, separated by spaces
  public String toString()
  {
    String retString = "";
    for(int i = 0; i < _list.size(); i++){
      retString += _list.get(i) + " ";
    }
    return retString;
  }//end toString()


  //main method for testing
  public static void main( String[] args )
  {

    
    Queue<String> PirateQueue = new ALQueue<String>();
    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");
    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...
    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println("\nnow dequeuing fr empty queue...\n" +
    "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue