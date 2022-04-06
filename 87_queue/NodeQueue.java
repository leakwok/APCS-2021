/* Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW87 -- The English Do Not Wait In Line for Soup
2022-04-03
time spent: 00.7 hrs 

DISCO:
- We used a tail pointer so it was easier to add new elements, since using setNext() changes the element immediately after the first one in _queue.
- _tail had a NullPointerException in the else of enqueue() until we added _head = _queue; and _tail = _queue; in the first part of the if. _tail needs to be told again to not point to null, but the new node added.

QCC:
- Do we need a head pointer?
- Was a nested class the right move?

*/

public class NodeQueue<QUASAR> implements Queue<QUASAR>{
    
    //instance variables
    private LLNode<QUASAR> _queue;
    private LLNode<QUASAR> _head;
    private LLNode<QUASAR> _tail;

    //constructor (is this necessary?)
    public NodeQueue(){
        _queue = null;
        _head = _queue;
        _tail = _head;
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public QUASAR dequeue(){
        QUASAR blah = _queue.getCargo();
        LLNode<QUASAR> temp = _queue.getNext();
        _queue = temp;
        _head = _queue;
        return blah;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( QUASAR x ){
        if(isEmpty()){
            LLNode<QUASAR> temp = new LLNode<QUASAR>(x, null);
            _queue = temp;
            _head = _queue;
            _tail = _queue;
        }
        else{
            LLNode<QUASAR> temp = new LLNode<QUASAR>(x, null);
            _tail.setNext(temp);
            _tail = _tail.getNext();
        }
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
        if(_queue == null){
            return true;
        }
        return false;
    }

    //Returns the first element of the queue without dequeuing it.
    public QUASAR peekFront(){
        return _queue.getCargo();
    }

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
    
    public static void main(String[] args){
        NodeQueue<Integer> line1 = new NodeQueue<Integer>();
        System.out.println(line1.isEmpty()); //expected: true

        line1.enqueue(1); // queue: 1
        line1.enqueue(2); // queue: 1 -> 2
        line1.enqueue(3); // queue: 1 -> 2 -> 3
        
        System.err.println(line1.peekFront()); //expected: 1

        line1.dequeue(); // queue: 2 -> 3
        System.err.println(line1.peekFront()); //expected: 2

        line1.dequeue(); // queue: 3
        System.err.println(line1.peekFront()); //expected: 3


    }

}//end NodeQueue class