/* Unicorn Unicodes: Eric, Lea, Kosta
APCS
HW90 -- Swabbing the Deque
2022-04-12
time spent: 00.8 hrs */

public interface Deque<Card>{

  public Card peekFirst();
  public Card peekLast();
  public int size();
  public boolean isEmpty();
  public void addFirst(Card c);
  public void addLast(Card c);
  public Card removeFirst();
  public Card removeLast();
  /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

}
