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
  private LLNode<QUASAR> _front, _end;
  private LLNode<QUASAR> _queue;
  private int _size;


  // default constructor creates an empty queue
  public ALQueue()
  {
    _size = 0;
    _front = _queue;
    _end = _front;
  }


  public void enqueue( QUASAR enQVal )
  {
    if(isEmpty()){
      LLNode<QUASAR> temp = new LLNode<QUASAR>(enQVal, null);
      _queue = temp;
      _front = _queue;
      _end = _queue;
    }
    else{
        LLNode<QUASAR> temp = new LLNode<QUASAR>(enQVal, null);
        _end.setNext(temp);
        _end = _end.getNext();
    }
  }//O(?)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public QUASAR dequeue()
  {
    int index = Math.random() * _size;
    int i = 0;
    LLNode beforeTarget = _front;
    while(i < index - 1) {
      beforeTarget = beforeTarget.getNext();
      i++;
    }
    LLNode target = beforeTarget.getNext();
    beforeTarget.setNext(beforeTarget.getNext().getNext());
    return target;
  }//O(?)


  public QUASAR peekFront()
  {

  }//O(?)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   < YOUR SUCCINCT SUMMARY HERE >
   **/
  public void sample ()
  {

  }//O(?)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String retString = "";
    int i = 1;
    LLNode<QUASAR> current = _front;
    while(i < _size) {
      retString += current.getCargo();
      current = current.getNext();
      i++;
    }
  }//end toString()


  public class LLNode<QUASAR>{
    //instance vars
    private QUASAR _cargo;
    private LLNode _nextNode;

    // constructor
    public LLNode( QUASAR value, LLNode<QUASAR> next )
    {
          _cargo = value;
          _nextNode = next;
      }

      //--------------v  ACCESSORS  v--------------
      public QUASAR getCargo()
      {
          return _cargo;
      }

      public LLNode<QUASAR> getNext()
      {
          return _nextNode;
      }
      //--------------^  ACCESSORS  ^--------------


      //--------------v  MUTATORS  v--------------
      public QUASAR setCargo( QUASAR newCargo )
      {
          QUASAR foo = getCargo();
          _cargo = newCargo;
          return foo;
      }

      public LLNode<QUASAR> setNext( LLNode<QUASAR> newNext )
      {
          LLNode<QUASAR> foo = getNext();
          _nextNode = newNext;
          return foo;
      }
  }//end LLNode class


  //main method for testing
  public static void main( String[] args )
  {

      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

    Queue<String> PirateQueue = new RQueue<String>();
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
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue