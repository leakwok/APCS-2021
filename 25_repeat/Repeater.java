/*
Ravenous Retribution: Salaj Rijal, Ariel Fuchs, Raven Tang, Lea Kwok
APCS
HW 25 -- Do I repeat myself? -- Making fence() with recursion and a while loop
2021-10-26

time spent: 0.5 hours


DISCO
- The same process/method can be executed in different ways (ex: while loop or recursion).
- It's possible to, in a way, "short circuit" a method. For example, if numPosts < 1 in either method, we immediately return an empty string and the rest of the method does not run.
- We were able to operate on the argument of numPosts and directly substract from it and use it in our while loop boolean expression instead of using a new variable.
- It's possible to have more than one base case. For example, in the recursive method, we have a base case for numPosts < 1 and a base case for numPosts == 1. Also, it is possible for a base case to never be called in a recursive reduction. For example, the case of numPosts < 1 will never be called in a recursive reduction, but it is still important to cover certain cases.
- Trying to input negative numbers and integer division into test cases will not return an error. Integer division will truncate to an integer argument, and negative numbers are covered by the numPosts < 1 conditional.
QCC
- Why are fenceW and fenceR static methods? 
*/

public class Repeater{
  
  //Iterative (While loop)
  public static String fenceW(int numPosts){ 
  //takes non-negative integer posts, and returns a String representation of a fence with the specified number of posts. Employs a while loop.
    if(numPosts < 1){
      return "";
    }
  	String result = "|";
    while(numPosts > 1){
      result += "--|";
      numPosts -= 1;
    }
    return result;
  }
  
  //Recursive
  public static String fenceR(int numPosts){ 
  //takes non-negative integer posts, and returns a String representation of a fence with the specified number of posts. Employs recursion.
    //Base Case 1 (numPosts is equal to 0)
    if(numPosts < 1){
      return "";
    }
    //Base Case 2 (numpPosts is equal to 1)
    if(numPosts == 1){
      return "|";
    }
    //Recursive reduction and call
    return fenceR(numPosts-1) + "--|";
  }
       
  public static void main(String[] args){
    //test calls of fenceW
    System.out.println( "Start of fenceW Tests: ");
    System.out.println( fenceW(1) ); //expected: "|"
    System.out.println( fenceW(2) ); //expected: "|--|"
    System.out.println( fenceW(6) ); //expected: "|--|--|--|--|--|"
    System.out.println( fenceW(-1) ); //expected: ""
    System.out.println( fenceW(-1/2) ); //expected: ""
    System.out.println( fenceW(3/2) ); //expected: "|"
    
    //test calls of fenceR
    System.out.println( "Start of fence R Tests: ");
    System.out.println( fenceR(1) ); //expected: "|"
    System.out.println( fenceR(2) ); //expected: "|--|"
    System.out.println( fenceR(6) ); //expected: "|--|--|--|--|--|"
    System.out.println( fenceR(-1) ); //expected: ""
    System.out.println( fenceR(-1/2) ); //expected: ""
    System.out.println( fenceR(3/2) ); //expected: "|"
    }
  }