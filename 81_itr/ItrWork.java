/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    - Use typecasting

    QCC

    SUMMARY THE FIRST:

    SUMMARY THE SECOND:

**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                LList<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    for(Integer i : L){
      if(i.equals(key)){
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                LList<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();

    while(it.hasNext()){
      Integer next = (Integer) it.next();
      if(next == key){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static LList<Integer> oddsA( LList<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    LList<Integer> odds = new LList<Integer>();
    for(Integer i : L){
      if(i % 2 == 1){
        odds.add(i);
      }
    }
    return odds;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static LList<Integer> oddsB( LList<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    LList<Integer> odds = new LList<Integer>();
    while(it.hasNext()){
      Integer next = (Integer) it.next();
      if(next % 2 == 1){
        odds.add(next);
      }
    }
    return odds;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( LList<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    while(it.hasNext()){
      Integer next = (Integer) it.next();
      if(next % 2 == 0){
        it.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: Integer
    LList<Integer> L = new LList<Integer>();
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop


    // b) explicitly using an iterator


    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    LList<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    LList<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
