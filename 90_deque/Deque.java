/* Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW91 -- Swabbing the Deque
2022-04-12/13
time spent: 1 hrs */

public interface Deque<Card>{

  public Card peekFirst();
  public Card peekLast();
  public int size();
  public boolean isEmpty();
  public void addFirst(Card c);
  public void addLast(Card c);
  public Card removeFirst();
  public Card removeLast();
  public Card getFirst();
  public Card getLast();
  public Card pollLast();
  public Card pollLast();
  public boolean offerFirst(Card c);
  public boolean offerLast(Card c);

  /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

}