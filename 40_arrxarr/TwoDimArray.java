// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW40 -- 2D arrays
// 2021-11-30
// time spent: 00.6 hour
/*
DISCO:
- The length of each row in a 2D array may not be the same throughout the array. When we ran print1() on m3, we originally iterated from 0 to a[0].length for j, but this lead to only the first element of each row being printed. We then changed it to a[i].length.
- In for loops, the value that you're iterating through has to be referenced by the actual indices, but in for-each loops, the value is the variable already.


QCC:
- Why do we have to intialize a variable when Java already has default values for primitives?
    int sum; 
        Gave us an error that variable sum might not have been initialized
    int sum = 0;
        Code compiled
- A tracker variable that is initialized at the beginning of the method and then returned at the end is helpful for printing out and summing the contents of an Object that can be iterated through.


*/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a )
  {
    // YOUR IMPLEMENTATION HERE
    String result = "";

        for( int i = 0; i < a.length; i++){
            for( int j = 0; j < a[i].length; j++){
                result += a[i][j] + " ";
            }
            result += "\n";
        }
        result += "";
        System.out.println(result);
    
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a )
  {
    // YOUR IMPLEMENTATION HERE
    String result = "";

        for( int[] i : a){
            for( int j : i){
                result += j + " ";
            }
            result += "\n";
        }
        result += "";
        System.out.println(result);
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    // YOUR IMPLEMENTATION HERE
    int sum = 0;
    
    for( int[] i : a){
            for( int j : i){
                sum += j;
            }
        }
    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    // YOUR IMPLEMENTATION HERE
    int y = 0;
    
    for ( int i = 0; i < m.length; i++){
        y += sumRow(i, m);
    }
    
    return y;
    
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    // YOUR IMPLEMENTATION HERE
    int x = 0;
    
    for( int i = 0; i < a[r].length; i++){
        x += a[r][i];
    }
    
    return x;

  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    // *** YOUR IMPLEMENTATION HERE ***
    int summer = 0;

    for ( int i : m[r] ){
        summer += i;
    }

    return summer;
  }


  public static void main( String [] args )
  {
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    // your own custom test cases welcomed and encouraged
      System.out.print("testing sumRow2...\n");
      System.out.println("sum m1[3] : " + sumRow2(3,m1));
      System.out.println("sum m2[1] : " + sumRow2(1,m2));
      System.out.println("sum m3[2] : " + sumRow2(2,m3));
  }

}//end class TwoDimArray