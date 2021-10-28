/* 
Leopard Rock
APCS
HW26 -- GCD Three Ways / codifying GCD algorithm flowchart from class, three ways: brute force, recursion, iterative while loop
2021-10-27
time spent: 00.5 hr
*/

/*
DISCO
- While loops can be used in a more iterative fashion and in brute force methods. 
- Modulus is a helpful operator in determining GCD, specifically in the brute force method. In the other methods, using what we were given in class (that the GCD of two numbers = the GCD of the difference between the numbers and the smaller number) is extremely helpful.
- Printing out separators in test cases helps in comparing expected values and comparing different algorithms for the same task.

QCC
- Why are the gcd methods static?
- Why do we get different return values when the inputs are both negative numbers? Does the way Java stores numbers have to do with the return for the recursive algo being 1? Why does the recursive algo stop while the iterative algo continues, seemingly forever?

ALGO
- (Is a == 1?) 
	- (If true, return 1.)
  - (If false, is b == 1?)
  	- (If true, return 1.)
    - (If false,) is a == b?
    	- If true, return a.
      - If false, is a > b?
      	- If true, return gcd(a-b, b).
        - If false, return gcd(a, b-a).
*/

public class Stats{
	
  //brute force, while loop beginning at 1 and working up to lesser input
  public static int gcd(int a, int b){
  	//determine which input is lesser
    int lesser;
    if(a < b){
    	lesser = a;
    }
    else{
    	lesser = b;
    }
    int x = 1;
    int curr = x;
    while(x <= lesser){
      if(a%x == 0 && b%x == 0){
        curr = x;
      }
			x += 1;
    }
    return curr;
  }
  
  //recursion
	public static int gcdER(int a, int b){
  	if(a == b) {
    	return a;
    } else if(a > b) {
    	return gcd(a-b, b);
    } else {
    	return gcd(a, b-a);
    }
  }
  
  //iteration
  public static int gcdEW(int a, int b){
  	while(a != b){
    	if(a < b){
      	b = b-a;
      }
      else{
      	a = a-b;
      }
    }
    return a;
  }
  
  public static void main(String[] args){
    
  	//testing brute force
    System.out.println("Test for brute force:");
    System.out.println(gcd(3, 3)); //expected: 3
    System.out.println(gcd(9, 15)); //expected: 3
    System.out.println(gcd(15, 18)); //expected: 3
    System.out.println(gcd(3, 14)); //expected: 1
    System.out.println(gcd(16, 28)); //expected: 4
    System.out.println(gcd(1, 40)); //expected: 1
    System.out.println(gcd(20, 12)); //expected: 4
    System.out.println(gcd(-20, -12)); //expected: 1
    
    //testing recursion
    System.out.println("Test for recursion:");
    System.out.println(gcdER(3, 3)); //expected: 3
    System.out.println(gcdER(9, 15)); //expected: 3
    System.out.println(gcdER(15, 18)); //expected: 3
    System.out.println(gcdER(3, 14)); //expected: 1
    System.out.println(gcdER(16, 28)); //expected: 4
    System.out.println(gcdER(1, 40)); //expected: 1
    System.out.println(gcdER(20, 12)); //expected: 4
    System.out.println(gcdER(-20, -12)); //expected: not sure
    
    //testing iteration
    System.out.println("Test for iteration:");
    System.out.println(gcdEW(3, 3)); //expected: 3
    System.out.println(gcdEW(9, 15)); //expected: 3
    System.out.println(gcdEW(15, 18)); //expected: 3
    System.out.println(gcdEW(3, 14)); //expected: 1
    System.out.println(gcdEW(16, 28)); //expected: 4
    System.out.println(gcdEW(1, 40)); //expected: 1
    System.out.println(gcdEW(20, 12)); //expected: 4
    //System.out.println(gcdEW(-20, -12)); //expected: no return
  }

}