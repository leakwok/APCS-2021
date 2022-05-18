/*
Fried Chicken :: Nina Jiang, Lea Kwok, Lindsay Phung
APCS pd7
HW102 -- Heap On Heapin' On / codifiying algos from previous hw
2022-05-18w
time spent: 02.5 hrs

DISCO:
* It's good to have an ArrayList and tree drawn out next to each other so visualization
  is easier.
* Make sure to draw out test cases BEFORE running main method so you know exactly
  what the output is.
* It's beneficial to print lines in certain parts of a while loop to see where the
  problem specifically is.
* A right child cannot exist without a left child.

QCC:
* What is -Xdiags:verbose and what is it's difference to -Xlint:unchecked?

*/

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

import javax.swing.text.PlainDocument;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    return _heap.toString();
  }//O(1)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.size() == 0;
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
      * add the new val to the end of the ArrayList
      * compare the new node to its parent, if val < parent, swap them
      * continue until val >= parent
   */
  public void add( Integer addVal )
  {
    _heap.add(addVal); //to the very end

    int val = _heap.size() - 1;
    int parent = (val - 1) / 2;

    //keep comparing to parent node and swap if val < parent
    while(_heap.get(parent) > _heap.get(val)) {
      swap(val, parent);
      val = parent;
      parent = (val - 1) / 2;
    }

  }//O(n)


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
      * swap the root (min val) and last leaf (last element in ArrayList)
      * remove the root (which is now at the end of the ArrayList)
      * if there are children of the new root, compare to the least child to see if new root > child
      * if new root > child, swap them
      * continue swapping until new root <= child
   */
  public Integer removeMin()
  {
    int removed = _heap.get(0);

    int start = 0;

    int last = _heap.size()-1;

    swap(start, last); //swap root

    _heap.remove(last); //remove the least val

    while(minChildPos(start) != 1){ //check if there are children
      System.out.println("I HAVE CHILDREN");

      if(_heap.get(start) > _heap.get(minChildPos(start))){ //check if parent > least child
        System.out.println("MY CHILDREN ARE SMALLER THAN ME");

        swap(start, minChildPos(start) ); //if so swap
        System.out.println("I HAVE SWAPPED");

        start = minChildPos(start); //if swapped, then point parent index to previous index of least children
        System.out.println("MY INDEX IS FIXED");
      }

    }

    return removed;

  }//O(n)


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
   private int minChildPos( int pos )
  {
    //no children: check 2pos + 1 and 2pos + 2 > _heap.get(pos)
    //input not in ArrayList: pos > size()-1
    //one child: 2pos +1 > _heap.get(pos)  return true
    //two children: 2pos +1 > _heap.get(pos) && 2pos + 2 > _heap.get(pos), return lesser one

    if((2*pos + 1) < _heap.size()-1 && (2*pos + 2) < _heap.size()){ //both children exist
        if(minOf(_heap.get(2 * pos + 1), _heap.get(2 * pos + 2)) == _heap.get(2 * pos + 1) ) { //see if the lesser one is the left child
    
            return 2 * pos + 1; //return index of left
        }
        else return 2 * pos + 2; //return index of right
    }

    if((2*pos + 1) < _heap.size()){ //only left child exists
        return 2 * pos + 1; //return index of left
    }

    if ((_heap.size() - 1) < (2 * pos  + 1) || pos > (_heap.size() - 1)) { //no children or not in heap
      return -1;
    }

    return -1;
  }//O(n)? 


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile); //[2]
      pile.add(4);
      System.out.println(pile); //[2, 4]
      pile.add(6);
      System.out.println(pile); //[2, 4, 6]
      pile.add(8);
      System.out.println(pile); //[2, 4, 6, 8]
      pile.add(10);
      System.out.println(pile); //[2, 4, 6, 8, 10]
      pile.add(1);
      System.out.println(pile); //[1, 4, 2, 8, 10, 6]
      pile.add(3);
      System.out.println(pile); //[1, 4, 2, 8, 10, 6, 3]
      pile.add(5);
      System.out.println(pile); //[1, 4, 2, 5, 10, 6, 3, 8]
      pile.add(7);
      System.out.println(pile); //[1, 4, 2, 5, 10, 6, 3, 8, 7]
      pile.add(9);
      System.out.println(pile); //[1, 4, 2, 5, 9, 6, 3, 8, 7, 10]

      System.out.println(pile.minChildPos(0)); //2
      System.out.println(pile.minChildPos(1)); //3 
      System.out.println(pile.minChildPos(2)); //6
      System.out.println(pile.minChildPos(3)); //8
      System.out.println(pile.minChildPos(4)); //9
      System.out.println(pile.minChildPos(5)); //-1
      System.out.println(pile.minChildPos(6)); //-1
      System.out.println(pile.minChildPos(7)); //-1
      System.out.println(pile.minChildPos(8)); //-1
      System.out.println(pile.minChildPos(9)); //-1
      System.out.println(pile.minChildPos(10)); //-1


      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[2, 4, 3, 5, 9, 6, 10, 8, 7]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[3, 4, 7, 5, 9, 6, 10, 8]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[4, 5, 7, 8, 9, 6, 10]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[5, 8, 7, 10, 9, 6]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[6, 8, 7, 10, 9]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[7, 8, 9, 10]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[7, 8, 9, 10]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[8, 10, 9]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[9, 10]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[10]
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile); //[]
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class ALHeap
