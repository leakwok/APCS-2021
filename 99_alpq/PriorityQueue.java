/*
Fried Chicken :: Nina Jiang, Lea Kwok, Lindsay Phung
APCS pd7
HW99 -- Some Are More Equal Than Others, Codified / prioritized queue
2022-05-16m
time spent: 0.5 hrs
*/

public interface PriorityQueue
{
    public void add( int x );

    public boolean isEmpty();

    public int peekMin();

    public int removeMin();
}