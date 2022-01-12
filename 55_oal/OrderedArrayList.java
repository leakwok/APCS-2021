// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW55: Never Fear, Big Oh Is Here!
// 2022-01-12
// time spent: 01.0 hr
// collaborated with TDD in class

/*
DISCO:
- Looking at ArrayList methods and determining their execution times in class were helpful for looking at OrderedArrayList!
- ArrayList and OrderedArrayList seem to have almost the same execution times for all methods, except for add (addLinear and addBinary) because some kind of iteration is required in OrderedArrayList to place elements in their correct positions.
- It's helpful to think of execution times, like O(1), O(n), etc., with their names. For example, thinking of O(1) time as constant time makes sense because it serves as a reminder that the execution time is constant in all cases.

QCC:
- Is it necessary to categorize execution time of constructors? They are technically methods, and they could have different run times, but are they relevant to our understanding of the runtimes of methods in a class?
- We're still confused about what k is in the formal definition of execution time.
- It seems like the execution time of O(log_2(n)) we assigned to addBinary is amortized, because in the really bad case where the ArrayList is full and needs to be expanded, the execution time would be O(log_2(n) + n). However, because this only occurs in one case, we can amortize the execution time.
*/

import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case, worst case don't apply b/c this method is simply a constructor and so it has the same execution time in all cases
    - execution time: O(1) b/c just initializes a new ArrayList<Integer> and is the same in all cases
  */
  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
	_data = new ArrayList<Integer>();
  }

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case, worst case don't apply b/c the method will simply iterate through the internal array exactly one time
    - execution time: O(n) b/c the method completes one complete iteration through all the elements of _data
  */
  public String toString()
  {
      return _data.toString();
  }

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case: int i = size of ArrayList-1 b/c no elements need to be shifted, only the viewing window of the ArrayList needs to be updated
      - execution time: O(1) b/c the only action that takes place is updating the value of an integer instance variable, which takes constant time
    - worst case: int i = 0 b/c all the other elements needed to be shifted
      - execution time: O(n) b/c each element has to be shifted
  */
  public Integer remove( int i )
  {
      return _data.remove(i);
  }

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case, worst case don't apply b/c in all cases, this method simply accesses the value of an instance variable of OrderedArrayList
    - execution time: O(1) b/c accessing the value of a variable takes constant time
  */
  public int size()
  {
      return _data.size();
  }

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case, worst case don't apply b/c it doesn't matter what the size of the ArrayList is. This method will always just find the value at an index
    - execution time: O(1) b/c accessing the value of an array element takes constant time
  */
  public Integer get( int i )
  {
      return _data.get(i);
  }

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case: newVal is less than all of the current elements of the ArrayList b/c the method does not need to continue iterating after checking the first index
      - execution time: O(1) b/c the method doesn't need to complete any iterations. It just makes one comparison, which takes constant time.
    - worst case: newVal is greater than all of the current elements of the ArrayList b/c the method needs to iterate through all the elements to determine the index that newVal belongs at
      - execution time: O(n) b/c the method completes one iteration in order to determine newVal's index
  */
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  public void addLinear(Integer newVal)
  {
      if(this.size() == 0){
        _data.add(newVal);
      }
      else {
        boolean found = false;
        for(int i = 0; i < this.size(); i++){
          if(newVal < this.get(i)){
            _data.add(i, newVal);
            found = true;
            break;
          }
        }
        if(found == false){
          _data.add(this.size(), newVal);
        }
      }

  }


  /*
  EXECUTION TIME CLASSIFICATION:
    - best case: newVal belongs at index (size-1)/2 b/c this is the best case in addBinaryHelper for low = 0 and high = this.size()
      - execution time: O(1) b/c it is the execution time for the best case in addBinaryHelper
    - worst case: newVal is greater than or less than all the current elements of ArrayList b/c this is the worst case in addBinaryHelper for low = 0 and high = this.size()
      - execution time: O(log_2(n)) b/c it is the executino time for the best case in addBinaryHelper
  */
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  public void addBinary(Integer newVal)
  {
      int low = 0;
      int high = this.size();

      addBinaryHelper(newVal, low, high);
  }

  /*
  EXECUTION TIME CLASSIFICATION:
    - best case: newVal belongs at index (low+high)/2 b/c on the first check, the condition will be fulfilled and the method would break
      - execution time: O(1) b/c low and high don't need to be updated, so only one comparison is necessary
    - worst case: newVal belongs at index low or index high b/c either low or high needs to be updated many times until it's brought to the other's initial value
      - execution time: O(log_2(n)) b/c low or high needs to be updated as many times as it takes to halve the ArrayList to one element
  */
  public void addBinaryHelper(Integer newVal, int low, int high)
  {

      //System.out.println("low: " + low);
      //System.out.println("high: " + high);

      int mid = (low+high)/2;
      if(this.size() == 0){
      	_data.add(newVal);
      }
      else if(this.size() == 1){
      	if(newVal > this.get(0)){
      		_data.add(newVal);
      	}
      	else{
      		_data.add(0, newVal);
      	}
      }
      else if(low == this.size()-1){
      	_data.add(newVal);
      }
      else if(high == 0){
      	_data.add(0, newVal);
      }
      else if(newVal >= this.get(mid)){
      	if(this.size() == mid+1 || newVal <= this.get(mid+1)){
      		_data.add(mid+1, newVal);
      	}
      	else{
      		low = mid;
      		addBinaryHelper(newVal, low, high);
      	}
      }
      else{
      	high = mid;
      	addBinaryHelper(newVal, low, high);
      }
  }

  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList Franz = new OrderedArrayList();
    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( Franz );
    /*=====^====================================^=========
   =====^====================================^=========*/

    // testing binary search
    Franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ ){
      Franz.addBinary( (int)( 50 * Math.random() ) );
    }
    System.out.println( Franz );
  }//end main()

}//end class OrderedArrayList