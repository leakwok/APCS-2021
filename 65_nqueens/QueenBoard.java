// Watermelon (Lea Kwok, Nina Jiang, Lawrence Joa)
// APCS pd7
// HW65 -- How Many Queens Can a Thinker Place, If a Thinker Can Place Queens...
// 2022-02-16
// time spent: 00.8 hrs

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */


/*
initialize board, fill with 0s
*/
public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    if(solveH(0)){
        return true;
    }
    return false;
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if(col == _board.length){
        return true;
    }

    for(int row = 0; row < _board.length; row++){
        if(addQueen(row, col)){
            if(solveH(col+1)){
                return true;
            }
            
            removeQueen(row, col);
            
        }
        
    }
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        if(_board[r][c] <= 0){
            ans += "_"+"\t";
        }
        else if(_board[r][c] == 1){
            ans += "Q"+"\t";
        }
        else{
            ans += _board[r][c]+"\t";
        }
      }
      ans += "\n";
    }
    System.out.println(ans); 

  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * precondition:0<=row,column<size
   * postcondition:
   if _board[row][col]==0, return true
   if _board[row][col]!=0, return false
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition:0<=row,column<size
   * postcondition:
   if _board[row][col]==1, return true
   if _board[row][col]!=1, return false
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition:
   * postcondition: print board
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    // System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    /* b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b); */
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    /* b.removeQueen(3,0);
    System.out.println(b); */
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */ 

    System.out.println(b.solve());
    b.printSolution();

    //test 8
    QueenBoard c = new QueenBoard(8);
    System.out.println(c.solve());
    c.printSolution();

    //test 9
    QueenBoard d = new QueenBoard(9);
    System.out.println(d.solve());
    d.printSolution();

    //test 11
    QueenBoard e = new QueenBoard(11);
    System.out.println(e.solve());
    e.printSolution();

    //test 13
    QueenBoard f = new QueenBoard(13);
    System.out.println(f.solve());
    f.printSolution();

    //test 20
    QueenBoard g = new QueenBoard(20);
    System.out.println(g.solve());
    g.printSolution();
  }

}//end class