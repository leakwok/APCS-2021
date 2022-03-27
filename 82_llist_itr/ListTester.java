/***
Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW80 -- Generically Speaking
2022-03-24
time spent: 00.6 hrs
 *
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 *  overriding List interface from standard Java library
 **/

public class ListTester
{
  public static void main( String[] args )
  {

    //instantiate... var type List, obj type LList
    List<Integer> wu = new LList<Integer>();

    System.out.println(wu);
    wu.add(35);

    System.out.println(wu);
    wu.add(58);

    System.out.println(wu);
    wu.add(1, 91 );

    System.out.println(wu);
    wu.remove(2);

    System.out.println(wu);
    wu.get(1);

    System.out.println(wu);
    wu.set(1, 324);

    System.out.println(wu.size());

    System.out.println(wu);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    System.out.println(wu);
    wu.add("Inspectah Deck");

    System.out.println(wu);
    wu.add("Raekwon the Chef");

    System.out.println(wu);
    wu.add("U-God");

    System.out.println(wu);
    wu.add("Ghostface");

    System.out.println(wu);
    wu.add("Method Man");

    System.out.println(wu);

    for( int i=0; i<7; i++ ) {
        int n = (int)( wu.size() * Math.random() );
        String imposter = "@";
        System.out.println("adding a poser at index " + n + "...");
        wu.add( n, imposter );
        System.out.println("Updated list: " + wu);
    }

    while( wu.size() > 0 ) {
        int n = (int)( wu.size() * Math.random() );
        System.out.println("deleting node "+ n + "...");
        wu.remove(n);
        System.out.println("Updated list: " + wu);
    }
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class