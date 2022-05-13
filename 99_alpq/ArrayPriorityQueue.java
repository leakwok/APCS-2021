import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue
{
    //instance vars
    private static ArrayList<Integer> _queue;
    private Integer _head; //do we need this



    //constructor
    public ArrayPriorityQueue(){
      _queue = new ArrayList<Integer>();
    }

    //methods


    public String toString(){
      return _queue.toString();
    }

    /* public boolean hasPriority(){

    } */ //we may not need this

    public boolean isEmpty(){
      if (_queue == null){
        return true;
      }
      return false;
    }


    public void add( int x ){
      _queue.add(x);
    }

    public int peekMin(){
      int smallest;
      for(Integer i : _queue){
        if(i < smallest){
          smallest = i;
        }
      }

      return smallest;
    }

    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getPriority(int index){

    }

    public int setPriority(int index){

    }




    public int removeMin();

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

    public static void main(String[] args){
      ArrayPriorityQueue tarik = new ArrayPriorityQueue();
      tarik.add(34);
      tarik.add(267);
      System.out.println(tarik);
    }
}
