/*
lourve -- Lea Kwok and Lindsay Phung
APCS
HW64 -- Revisitation / codingbat recursion-1 + recursion-2
time spent: 1 hr

Given a non-negative int n, return the sum of its digits recursively (no loops).
Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide
(/) by 10 removes the rightmost digit (126 / 10 is 12).

sumDigits(126) → 9
sumDigits(49) → 13
sumDigits(12) → 3
*/

public class sumDigits {

    public static int sumDigits(int n) {
      if (n < 10) {
        return n;
      }
      else {
        return n % 10 + sumDigits(n/10);
      }
    }
  
    public static void main(String[] args) {
      System.out.println(sumDigits(126));
      System.out.println(sumDigits(49));
      System.out.println(sumDigits(12));
      System.out.println(sumDigits(10110));
    }
  
  }