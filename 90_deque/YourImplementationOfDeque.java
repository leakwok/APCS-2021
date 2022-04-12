/* Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW90 -- Swabbing the Deque
2022-04-12
time spent: 00.8 hrs */

import java.util.LinkedList;

public class YourImplementationOfDeque<Card> implements Deque<Card>{
    //instance vars
    private LinkedList<Card> _deque = new LinkedList<Card>();

    public Card peekFirst(){
        return _deque.getFirst();
    }

    public Card peekLast(){
        return _deque.getLast();
    }

    public int size(){
        return _deque.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    
    public void addFirst(Card c){
        _deque.addFirst(c);
    }

    public void addLast(Card c){
        _deque.add(c);
    }

    public Card removeFirst(){
        return _deque.removeFirst();
    }

    public Card removeLast(){
        return _deque.removeLast();
    }

    public String toString(){
        String retString = "";
        for(int i = 0; i < _deque.size(); i++){
        retString += _deque.get(i) + " ";
        }
        return retString;
    }//end toString()

    public static void main( String[] args ){

        YourImplementationOfDeque<String> PirateQueue = new YourImplementationOfDeque<String>();
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