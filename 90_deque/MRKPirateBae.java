/* Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW91 -- Swabbing the Deque
2022-04-12/13
time spent: 1.0 hrs */

public class MRKPirateBae {
    public static void main( String[] args ){
        LLDeque<String> PirateQueue = new LLDeque<String>();
        System.out.println(PirateQueue.isEmpty()); //expected: true
        System.out.println("\nnow enqueuing...");
  
        PirateQueue.addFirst("Dread"); //expected: Dread
        System.out.println(PirateQueue.peekFirst()); //expected: Dread
  
        PirateQueue.addFirst("Pirate"); //expected: Pirate Dread
        System.out.println(PirateQueue.peekFirst()); //expected: Pirate
  
        PirateQueue.addLast("Roberts"); //expected: Pirate Dread Roberts
        System.out.println(PirateQueue.peekLast()); //expected: Roberts
  
        PirateQueue.addLast("Blackbeard"); //expected: Pirate Dread Roberts Blackbeard
        System.out.println(PirateQueue.peekLast()); //expected: Blackbeard
  
        PirateQueue.addFirst("Peter"); //expected: Peter Pirate Dread Roberts Blackbeard
        System.out.println(PirateQueue.peekFirst()); //expected: Peter
  
        PirateQueue.addLast("Stuyvesant"); //expected: Peter Pirate Dread Roberts Blackbeard Stuyvesant
        System.out.println(PirateQueue.peekLast()); //expected: Stuyvesant
  
        System.out.println(PirateQueue.isEmpty()); //expected: false
        System.out.println(PirateQueue.size()); //expected: 6
  
        System.out.println("\nnow testing toString()...");
        System.out.println( PirateQueue ); //for testing toString()...
  
        System.out.println("\nnow dequeuing...");
        System.out.println( PirateQueue.removeFirst() ); //expected: Peter
        System.out.println( PirateQueue ); //expected: Pirate Dread Roberts Blackbeard Stuyvesant
  
        System.out.println( PirateQueue.removeFirst() ); //expected: Pirate
        System.out.println( PirateQueue ); //expected: Dread Roberts Blackbeard Stuyvesant
  
        System.out.println( PirateQueue.removeLast() ); //expected: Stuyvesant
        System.out.println( PirateQueue ); //expected: Dread Roberts Blackbeard
  
        System.out.println( PirateQueue.removeLast() ); //expected: Blackbeard
        System.out.println( PirateQueue ); //expected: Dread Roberts
  
        System.out.println( PirateQueue.removeFirst() ); //expected: Dread
        System.out.println( PirateQueue ); //expected: Roberts
  
        System.out.println( PirateQueue.removeLast() ); //expected: Roberts
        System.out.println( PirateQueue ); //expected:
  
        System.out.println(PirateQueue.isEmpty()); //expected: true
        /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
  
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//end main
  }