// Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).

public class factorial{

  public static int factorial(int n) {
    if(n == 1){
      return 1;
    }
    else {
      // for(int i = n; i > 0; i--){
      //   for(int j = n-1; j>0; j--){
      //       temp = j;
      //   }
      //   answer = n*temp;
      // }
      return n*factorial(n-1);
    }
    //return answer;
  }
  public static void main(String[] args){
    System.out.println(factorial(1));
    System.out.println(factorial(2));
    System.out.println(factorial(5));
  }
}
