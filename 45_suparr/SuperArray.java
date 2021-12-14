// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW45 -- Array of Titanium
// 2021-12-08
// time spent: 01.1 hours
/*
DISCO:
- SuperArray cannot override the return type given in the interface.
- The headers for the methods have to be the same in the interface and the implementation. For example, the add() method returned a boolean in the List Interface, but we wanted add() to be void in SuperArray. So, we needed to match the return types for it to compile.
- Interface implementation allows you to require any class that implements the Interface to have all of the methods specified in the Interface. If you initialize an object with object type SuperArray() and variable ListInt, ListInt specifies what methods you may use, and SuperArray() specifies the implementation of the methods. However, the object would still be able to perform methods like toString() because of inheritance. Instance variables of SuperArray() cannot be accessed.

QCC:
- Can an interface have instance variables? Is there a way to access these variables in the implementation if not?
- We received these error messages when our return types did not match for a method in ListInt and SuperArray.
  error: SuperArray is not abstract and does not override abstract method add(int) in ListInt
  error: add(int) in SuperArray cannot implement add(int) in ListInt
  return type void is not compatible with boolean
- We got this message after trying to access an instance variable and method of SuperArray through a ListInt object.
  error: cannot find symbol 

*/

public class SuperArray implements ListInt
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
    if the index is out of bounds of SuperArray, print error message
    return the old value at index, which was stored in the temporary variable
  */
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    if(index > _size-1){
      System.out.println("Attempted to set value of out of bounds element.");
    }
    return temp;
  }


  //adds an item after the last item
  /* algo:
    if _data doesn't have space for another element, expand()
    set the element at index size to newVal
    increment size by 1
  */
  public boolean add( int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    if(_size == _data.length){
	     expand();
    }
    _data[_size] = newVal;
    _size += 1;
    return true;
  }


  //inserts an item at index
  /* algo:
    if _data doesn't have space for another element, expand()
    if index is out of bounds of the SuperArray (meaning it's >= _size, not necessarily >= _data.length), print error message
    otherwise, iterate from the rightmost meaningful element to the element at the desired index, shifting each element to the right, set the element at index to newVal, and increment size by 1
  */
  public void add( int index, int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    if(_size == _data.length ){
	     expand();
    }
    if(index >= _size){
      System.out.println("Attempted to add index out of bounds element.");
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
      ListInt curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < 10; i++ ) {
          curtis.add( i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      ListInt mayfield = new SuperArray();
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
