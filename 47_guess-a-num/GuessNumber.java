import java.util.Scanner;

public class GuessNumber{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;
    Scanner sc = new Scanner(System.in);

    public GuessNumber( int a, int b){
        _lo = Math.min(a,b);
        _hi = Math.max(a,b);
        _guessCtr = 1;

        //pick random number in range [a,b]
    }

    public void playRec(){
        System.out.print("Guess a num bt" + _lo + " & " + _hi + ": ");
        int guess = sc.nextInt();

        //3 cases: we either found it, too hi, too lo
    }

    public void playItr(){
        int guess;

        while (true){
            System.out.print("Guess a num bt" + _lo + " & " + _hi + ": ");
            guess = sc.nextInt();

            //3 cases: we either fount it, too hi, too lo

            _guessCtr += 1;
        }
    }

    public void play(){
        //playRec()

        playItr();

    }

    //main method
    public static void main(String[] args){
        //instantiate a new game
        GuessNumber g = new GuessNumber(1, 100);

        //start the game
        g.play();
    }
}//end class GuessNumber