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
    * O(1)
    */
    public void add( int x ){
        _queue.add(x);
    }

    /**
    * int peekMin()
    * Returns the smallest item stored in this priority queue without removing it.
    * O(n)
    */
    public int peekMin(){
      int smallest = _queue.get(0);
      for(Integer i : _queue){
        if(i < smallest){
          smallest = i;
        }
      }

      return smallest;
    }

    /**
    * int removeMin()
    * Removes and returns the smallest item stored in this priority queue.
    * O(n)
    */
    public int removeMin(){
      int removed = _queue.get(0);
      int index = 0;
      for(int i = 0; i < _queue.size(); i++){
        if(removed > _queue.get(i)){
          removed = _queue.get(i);
          index = i;
        }
      }

      return _queue.remove(index);
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