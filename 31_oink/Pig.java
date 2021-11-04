/***
 /*
Downtown Leopard Rocks: David Chen, Lea Kwok, Raven Tang
APCS
HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay -- Using loops for finding vowels
11-03-2021
time spent: 00.6 hours

DISCO
- We can call upon methods that we already wrote in the new methods we're creating.
- Instead creating String variables for each vowel, combining all of them into one instance variable that cannot be changed saved a lot of time and space.
- When testing cases of a method that return an empty String, if the output is printed in Terminal, it is still apparent that the correct output is displayed because there is an empty line.

QCC
- When we check if a letter is in a String, we have to state the precondition that letter.length() == 1 because we don't know how to compare chars and Strings yet.
- Why is VOWELS in all caps? Is that a convention for naming final instance variables?
- Why do we have a countVowel() and a hasVowel() method if a positive countVowel() return value implies a true return for hasVowel()?

 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: All vowels are held in the one String, rather than creating a new String for each vowel.
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    int i = 0;
    while(i < w.length()-1){
        if (w.substring(i,i+1).equals(letter)){
            return true;
        }
        i += 1;
    }
    return false;
  }//end hasA()

 /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    int i = 0;
    while(i < 4){
        if (VOWELS.substring(i,i+1).equals(letter.toLowerCase())){
            return true;
        }
        i += 1;
    }
    return false;
  }

/*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    int count = 0;
    for(int i = 0; i < w.length()-1; i++){
        if(isAVowel(w.substring(i, i+1))){
            count += 1;
        }
    }
    return count;
  }

/*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    int i = 0;
    while(i < w.length()-1){
        if (isAVowel(w.substring(i,i+1))){
            return true;
        }
        i += 1;
    }
    return false;
  }

  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    String vowStr = "";
    
    for(int i = 0; i < w.length()-1; i++){
        if(isAVowel(w.substring(i, i+1))){
            vowStr += w.substring(i, i+1);
        }
    }
    return vowStr;
  }

  public static void main( String[] args ) 
  {
    /* YOUR TEST CALLS HERE */
    System.out.println(hasA("cat", "a")); //expected: true
    System.out.println(hasA("cat", "p")); //expected: false

    System.out.println(isAVowel("e")); //expected: true
    System.out.println(isAVowel("E")); //expected: true
    System.out.println(isAVowel("w")); //expected: false

    System.out.println(countVowels("meatball")); //expected: 3
    System.out.println(countVowels("notebook")); //expected: 4
    System.out.println(countVowels("tycb")); //expected: 0

    System.out.println(hasAVowel("cat")); //expected: true
    System.out.println(hasAVowel("zzz")); //expected: false

    System.out.println(allVowels("meatball")); //expected: "eaa"
    System.out.println(allVowels("notebook")); //expected: "oeoo"
    System.out.println(allVowels("tycb")); //expected: ""


  }//end main()

}//end class Pig