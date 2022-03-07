// Oscar Breen, Lea Kwok, Neil Lin
// APCS p7
// HW70 -- maze solving (blind, depth-first)
// 2022-03-04r
// time spent: 1 hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: find a route through a maze
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 *  
   start
 *  IS maze solved?
     if so gg,
     	search for '@'
     		 replace all with '.' 
		 no more @?
		 	print maze
    if not, mark location with @
	search for hashtag from top clockwise
	move to first hashtag found
    		repeat start
	if no hashtag found place a . on your posiiton  and return to last position 
		repeat start

 * DISCO
 * it follows almost the exact same code pattern as knighttour
 * QCC
 * sending out all directions siumutaneously would eliminate backtracking and be very efficient 
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  private int h, w; // height, width of maze
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        h++;
        row++;
      }
      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    //primary base case
    if ( _maze[x][y] == '$' ) {
	_solved = true;
	for( int u = 0; u < _maze[y].length; u++){
	    for( int c = 0; c < _maze[x].length; c++){
	    	if(_maze[c][u] == '@')
	    	    _maze[c][u] = '.';
	    }
	}
	System.out.println( this );
	System.exit(0);
    }
    //other base cases
    else if ( !onPath(x,y) ) {
//      System.out.println("problem");
	return;

    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
	_maze[x][y] = '@';
      System.out.println( this ); //refresh screen
	solve(x,y-1);
	solve(x+1,y);
	solve(x,y+1);
	solve(x-1,y);
// didnt find anything, go back
	_maze[x][y] = '.';

      System.out.println( this ); //refresh screen

    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
       if(!(_maze[x][y] == '#'))
	return false;

       else
	return true;
 }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)
    // ThinkerTODO: comment next line out when ready to randomize startpos
//    ms.solve( 4, 3 );

    //drop our hero into maze at random location on path
    // YOUR RANDOM-POSITION-GENERATOR CODE HERE
    int startX= (int)(80*Math.random());
    int startY= (int)(25*Math.random());
    
    while(!ms.onPath( startX, startY)) {
      
	startX = (int)(80*Math.random());
      
	startY = (int)(25*Math.random());
/*
	boolean check = false;
        int startX = 5;
	int startY = 5;
	while(check = false){
  		 startX = (int)(50*Math.random());
  		 startY = (int)(50*Math.random());
   		if(ms.onPath(startX, startY)){
			check = true; }
         }
*/
} 
   ms.solve( startX, startY );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze