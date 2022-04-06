/***
Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW88 -- BPC Kiddies Do Not Wait in Line Either
2022-04-04
time spent: 00.8 hrs

DISCO:
- The sample() method doesn't have to be a true shuffle method, since only one node needs to be dequeued at a time.
- We only had to refactor dequeue() slightly and kept the other methods the same because sample() helped us move a random node to the front.

QCC:
- Is there a simpler way to write sample()?
- Can we use sample() on queues with less than 3 nodes? Would it be easier to just implement that into dequeue()?

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


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    //special case: when enqueuing to an empty list, 
    //make _front && _end point to same node
    if ( isEmpty() ) {
        _front = _end = new LLNode<SWASHBUCKLE>( enQVal, null );
      }
      else {
        _end.setNext( new LLNode<SWASHBUCKLE>( enQVal, null ) );
        _end = _end.getNext();
      }
      _size++;
      System.out.println("enqueued " + enQVal);
  }//O(1)


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    if(_size == 1){
        return peekFront();
    }
    if(_size == 2){
        return peekFront();
    }
    sample();
    SWASHBUCKLE retVal = peekFront();
    _front = _front.getNext();

    if ( _front == null ) //just moved past last node
      _end = null;      //update _end to reflect emptiness

    _size--;

    return retVal;
  }//O(n)


  public SWASHBUCKLE peekFront()
  {
    return _front.getCargo();
  }//O(1)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   *   pick a random target node
   *   move that node to the front of queue 
   **/
  public void sample ()
  {
    LLNode<SWASHBUCKLE> beforeTarget = _front;
    LLNode<SWASHBUCKLE> temp = _front.getNext();


    for(int i = 0; i < (int) (Math.random()*_size-1); i++){
        beforeTarget = _front.getNext();

    }

    LLNode<SWASHBUCKLE> target = beforeTarget.getNext();

    beforeTarget.setNext(target.getNext());
    target.setNext(_front);

    /* _front.setNext(target.getNext());
    beforeTarget.setNext(_front);
    target.setNext(temp); */

    _front = target;

  }//O(n)


  public boolean isEmpty()
  {
    return _front == null;
  } //O(1)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode<SWASHBUCKLE> tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

      
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
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue