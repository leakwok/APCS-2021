/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 **/

public class Scheme
{

  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    //make new stack
    LLStack<String> stack = new LLStack<String>();

    //make operation int
    int oper = 0;

    //make return str
    String finalAns = "";

    //split each character up and put in array
    String[] holderArr = expr.split("");

    //add each character to stack
    for(String s : holderArr){

        stack.push(s);

        //if operation is found, set operation int
        if(stack.peekTop().equals("+")){
          oper = 1;
        }
        if(stack.peekTop().equals("-")) {
          oper = 2;
        }
        if(stack.peekTop().equals("*")){
          oper = 3;
        }

        //search for )
        if(stack.peekTop().equals(")")){
          //pop )
          stack.pop();

          //pop \\s
          stack.pop();

          //unload 
          finalAns = unload(oper, stack);

          //add value back
          stack.push(finalAns);
        }

    }//end foreach


    return finalAns;
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, LLStack<String> numbers )
  {
    //make temp holder string
    String temp = "";

    //make return int
    int answer = 0;


    //pop all until reach operator
    while(!(numbers.peekTop().equals("+")) || !(numbers.peekTop().equals("-")) || !(numbers.peekTop().equals("*"))){
      //add each to temp str
      temp += numbers.pop();
    }
    

    //split string with regex
    String[] tempHold = temp.split("\\s");

    //perform operation
    if(op == 1){
      //addition
      for(String s : tempHold){
        answer += Integer.parseInt(s);
      }

    } else if(op == 2){
      //subtraction
      answer = Integer.parseInt(tempHold[tempHold.length-1]);
      for(int i = tempHold.length-2; i <= 0; i--){
        answer -= Integer.parseInt(tempHold[i]);
      }

    } else if(op == 3){
      //multiplication
      answer = Integer.parseInt(tempHold[0]);
      for(int i = 1; i < tempHold.length; i++){
        answer *= Integer.parseInt(tempHold[i]);
      }
    }

    //pop operator, \\s, (
    for(int i = 0; i < 3; i++){
      numbers.pop();
    }
    

    return String.valueOf(answer);

  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

    String zoo1 = "( + 4 3 )";
    System.out.println(zoo1);
    System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
