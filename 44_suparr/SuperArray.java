// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW44 -- Array of Grade 316
// 2021-12-07
// time spent: 01.2 hours
/*
DISCO:
- _data is the "underlying array" of SuperArray, according to a comment in the provided test cases. We need to check the length of the underlying array rather than _size for methods like expand() to make sure the size of _data has expanded, not the size of SuperArray just yet.
- It's helpful to write algorithm summary comments before methods that would benefit from them.
- After expanding a SuperArray, there should be no visual differences in the printed out SuperArray or in the _size of the SuperArray, even though the length of the underlying array is being updated.
- A possible way to "future proof" our methods is to consider what happens when a user attempts to remove or add an element past the index _size. We addressed the remove situation by checking if index >= _size and printing a message to the user without altering any values. We addressed the add situation by checking if index >= _size and invoking set() for the desired index and value. Doing so ensures that _size is properly updated to cover up to the recently added element rather than just being incremented by 1.

QCC:
- We started off with the skeleton code from the library for v1. However, we changed the for loop in expand() to iterate up to _size instead of _data.length. We felt that it wasn't necessary to copy over elements after _size in the previous _data to conserve memory used. Is there any advantage to using _data.length instead of _size?
- We ran into a problem with set(): the SuperArray would be printed as an empty [] even though the length of the underlying array was being updated. We realized that this problem came from not updating _size in the skeleton set() method. We updated _size by checking if an element was being set at an index past _size-1 (which is the last element of the previous SuperArray capacity).
- Our algorithm for a remove() method that takes no parameters and pops off the end of the SuperArray: simply let _size take the value of _size-1. We thought of _size as a curtain or sliding airplane window blind that limits how much of the underlying array a user can see when using a SuperArray. By decreasing _size by 1, the user is no longer allowed to see the last element, and the _size has been correctly updated as well.
*/

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  /* algo:
    initialize a String to be returned at the end of the method.
    iterate through the underlying array up to index _size, adding the elements to the result toString
    remove trailing comma if necessary
    add closing bracket and return result String
  */
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  /* algo:
    create a temporary array twice the size of _data for holding values
    iterate through _data to copy each meaningful element to the temporary array
    set the new _data array to the temporary one
  */
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _size; i++ ) //changed i < _data.length from skeleton code to i < _size
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  /* algo:
    create a holder variable for the element at the index
    change the element at the index to newVal
    if the index is out of bounds of SuperArray, update size to index+1
    return the old value at index, which was stored in the temporary variable
  */
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    if(index > _size-1){
      _size = index+1;
    }
    return temp;
  }


  //adds an item after the last item
  /* algo:
    if _data doesn't have space for another element, expand()
    set the element at index size to newVal
    increment size by 1
  */
  public void add( int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    if(_size == _data.length){
	     expand();
    }
    _data[_size] = newVal;
    _size += 1;
  }


  //inserts an item at index
  /* algo:
    if _data doesn't have space for another element or index is out of bounds of the underlying array, expand()
    if index is out of bounds of the SuperArray (meaning it's >= _size, not necessarily >= _data.length), use the set() method to ensure that _size is updated appropriately and not just incremented by 1
    otherwise, iterate from the rightmost meaningful element to the element at the desired index, shifting each element to the right, set the element at index to newVal, and increment size by 1
  */
  public void add( int index, int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    if(_size == _data.length || index >= _data.length){
	     expand();
    }
    if(index >= _size){
      set(index, newVal);
    }
    else{
      for(int i = _size-1; i > index-1; i--){
        _data[i+1] = _data[i];
      }
      _data[index] = newVal;
      _size += 1;
    }
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  /* algo:
    if index is out of bounds of the SuperArray (meaning index >= _size, not necessarily index >= _data.length), print statement about attempting to remove an element with index out of bounds
    otherwise, iterate from the element immediately following the element at the desired index up to the last meaningful element, shifting each element to the left by 1, and decrease _size by 1
  */
  public void remove( int index )
  {
    /* YOUR IMPLEMENTATION HERE */
    if(index >= _size){
      System.out.println("Attempted to remove index out of bounds element.");
    }
    else{
      for(int i = index+1; i < _size; i++){
        _data[i-1] = _data[i];
      }
      _size = _size-1;
    }
  }


  //return number of meaningful items in _data
  public int size()
  {
    /* YOUR IMPLEMENTATION HERE */
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
          curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
          curtis.expand();
          System.out.println("Printing expanded SuperArray curtis...");
          System.out.println(curtis);
          System.out.println("new length of underlying array: "
      + curtis._data.length );
      }

      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);

      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);

      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(6);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);

      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(9,8);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class