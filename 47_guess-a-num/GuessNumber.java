// Un-upTown Leopard Rock: Lea Kwok, Raven (Ruiwen) Tang
// APCS pd7
// HW47 - - Guess Again
// 2021-12-14
// time spent: 01.1 hours

/* 
DISCO:
- It is always to start with a plan before coding. This time, we sketched flow charts for both algorithms, and then worked on the code at home, which allowed us to complete the work faster.
- You can use return; in a void method to break a loop or stop running the method.
- These algorithms work for ranges with negative numbers.
- If the user inputs a number not in the range, the program won't break. _lo and _hi will update according to the guesses, and the range will increases, but the statements outputted by the program will still be true.

QCC: 
- Is there a more efficient way to pick a random number in the range to be the target? We did (int) (Math.random() * (b-a) + a).
- We realized that the iterative and recursive algorithms were extremely similar because the iterative one used a while loop that broke when true, which is like using recursion to get to the base case.
- Can we have the user pick which algorithm to use? Would there be a benefit to this?

*/

/***
 * class GuessNumber -- fun fun fun!
 *
 * SKELETON
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses
 ***/

 

import java.util.Scanner;

public class GuessNumber{
   
    //instance vars
    private int _lo, _hi, _guessCtr, _target;
    Scanner sc = new Scanner(System.in);

    /*==================================================
    constructor -- initializes a guess-a-number game
    pre:  
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
    public GuessNumber( int a, int b){
        _lo = Math.min(a,b);
        _hi = Math.max(a,b);
        _guessCtr = 1;

        //pick random number in range [a,b]
        _target = (int) (Math.random() * (b-a) + a);
    }

    /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
    public void playRec(){
        System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
        int guess = sc.nextInt();

        //3 cases: we either found it, too hi, too lo

        if(guess == _target){
            System.out.println("Correct! It took " + _guessCtr + " guesses");
            
        }
        else if(guess > _target){
            _guessCtr += 1;
            System.out.println("Too high");
            _hi = guess - 1 ;
            playRec();
        }
        else{
            _guessCtr += 1;
            System.out.println("Too low");
            _lo = guess + 1;
            playRec();
        }
    }

    /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
    public void playItr(){
        int guess;

        while (true){
            System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
            guess = sc.nextInt();

            //3 cases: we either fount it, too hi, too lo


            if(guess == _target){
                System.out.println("Correct! It took " + _guessCtr + " guesses");
                return;
            }
            else if(guess > _target){
                System.out.println("Too high");
                _hi = guess - 1 ;
                _guessCtr += 1;
            }
            else{
                System.out.println("Too low");
                _lo = guess + 1;
                _guessCtr += 1;
            }
        }
    }

    //wrapper for playRec/playIter to simplify calling
    public void play(){
        //playRec();
        playItr();
    }

    //main method to run it all
    public static void main(String[] args){
        
        //instantiate a new game
        GuessNumber g = new GuessNumber(1, 100);

        //start the game
        g.play();
        /*-----------------------------
        -----------------------------*/
    }

}//end class GuessNumber