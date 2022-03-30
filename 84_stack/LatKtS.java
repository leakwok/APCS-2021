/***
Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW84 -- Stack: What Is It Good For?
2022-03-29
time spent: 01.0 hrs

 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    Latkes stack = new Latkes(s.length());
    for(int i = 0; i < s.length(); i++) {
      stack.push(s.substring(i, i + 1));
    }
    String retString = "";
    while(! stack.isEmpty()) {
      retString += stack.pop();
    }
    return retString;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true )])([}{(
   *                allMatched( "([)]" )        -> false ])[(
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    Latkes stack = new Latkes(s.length());
    for(int i = 0; i < s.length(); i++) {
      stack.push(s.substring(i, i + 1));
    }
    if(! stack.isEmpty()) {
      
      
        if((s.substring(0,1).equals("(") || s.substring(0,1).equals("{") || s.substring(0,1).equals("["))&& (flip(s).substring(0,1).equals(")") || flip(s).substring(0,1).equals("}") || flip(s).substring(0,1).equals("]"))){
          return true;
      /* }else if(s.substring(0,1).equals("{") && flip(s).substring(0,1).equals("}")){
        return true;
      }else if(s.substring(0,1).equals("[") && flip(s).substring(0,1).equals("]")){
        return true;
        */
      } 
      else 
        return false;

    }
    if(stack.isEmpty())
        return true;
    return false;
  }


  //main method to test
  public static void main( String[] args )
  {
      System.out.println(flip("stressed"));
      System.out.println(allMatched( "({}[()])" )); //true
      System.out.println(allMatched( "([)]" ) ); //false
      System.out.println(allMatched( "(){([])}" ) ); //true
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class