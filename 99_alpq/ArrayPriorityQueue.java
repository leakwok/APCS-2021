/*
Fried Chicken :: Nina Jiang, Lea Kwok, Lindsay Phung
APCS pd7
HW99 -- Some Are More Equal Than Others, Codified / prioritized queue
2022-05-16m
time spent: 0.5 hrs
*/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue
{
    //instance vars
    private static ArrayList<Integer> _queue;

    //constructor
    public ArrayPriorityQueue(){
      _queue = new ArrayList<Integer>();
    }

    //toString
    public String toString(){
      return _queue.toString();
    }

    /**
    * boolean isEmpty()
    * Returns true if this stack is empty, otherwise returns false.
    * O(1)
    */
    public boolean isEmpty(){
      return _queue.size() == 0;
    }

    /**
    * void add( int x )
    * Adds an item to this priority queue.
    * We first scheck for an empty queue: if so, add. We then check to the queue
    * for a bigger number. If so, add at the index + 1. If not, add to the zeroth
    * index.
    * O(n)
    */
    public void add( int x ){
      if (isEmpty()) {
        _queue.add(x);
        return;
      }
      for (int i = 0; i < _queue.size(); i++) {
        if (x > _queue.get(i)) {
          _queue.add(i + 1, x);
          return;
        }
      }
      _queue.add(0, x);
    }

    /**
    * int peekMin()
    * Returns the smallest item stored in this priority queue without removing it.
    * O(1)
    */
    public int peekMin(){
      return _queue.get(0);
    }

    /**
    * int removeMin()
    * Removes and returns the smallest item stored in this priority queue.
    * O(1)
    */
    public int removeMin(){
      return _queue.remove(0);
    }

    public static void main(String[] args){
      ArrayPriorityQueue tarik = new ArrayPriorityQueue();
      System.out.println("empty: " + tarik.isEmpty());
      tarik.add(34);
      tarik.add(267);
      tarik.add(13);
      System.out.println(tarik);
      System.out.println("empty: " + tarik.isEmpty());
      System.out.println("minimum: " + tarik.peekMin());
      System.out.println("removing minimum... " + tarik.removeMin());
      System.out.println(tarik);
    }
}