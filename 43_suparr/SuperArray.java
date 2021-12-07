/* 
Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
APCS pd7
HW43 -- Array of Steel
2021-12-06
time spent: 00.6 hours

DISCO:
- For our toString() method, to delete the extra comma at the end, you can take the substring of the prior results String, or use a for loop to iterate until the last element and leave out the comma.
- Once again, we find that storage Arrays/result Strings are very helpful.
- When transferring elements from one Array to another, it is better to use for loops than for-each loops. 

QCC:
- As a note from class, putting an underscore in front of a name shows that it is an instance variable.
- Why is length a method of String class but an instance variable of the Array class? .length() vs .length
- Would it make a significant difference in the computer memory for the storage Array in expand() to be the same length as _data vs twice the length?
*/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    /* YOUR IMPLEMENTATION HERE */
    _data = new int[10];
    _size = _data.length;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    /* YOUR IMPLEMENTATION HERE */
    String results = "[";
    for(int i : _data){
        results += i + ",";
    }
    results = results.substring(0,results.length()-1);
    results += "]";
    return results;
  }


  //double capacity of SuperArray
  private void expand()
  {
    /* YOUR IMPLEMENTATION HERE */
    int[] holderArr = new int[_data.length];
    for(int i = 0; i < _data.length; i++){
        holderArr[i] = _data[i];
    }
    _data = new int[_data.length*2];
    for(int i = 0; i < holderArr.length; i++){
        _data[i] = holderArr[i];
    }

  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    /* YOUR IMPLEMENTATION HERE */
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    /* YOUR IMPLEMENTATION HERE */
    int hold;
    hold = _data[index];
    _data[index] = newVal;
    
    return hold;

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
      }
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class