public interface Deque<Card>{
  public Card peekFirst();
  public Card peekLast();
  public int size();
  public boolean isEmpty();
  public void addFirst();
  public void addLast();
  public Card removeFirst();
  public Card removeLast();
}
