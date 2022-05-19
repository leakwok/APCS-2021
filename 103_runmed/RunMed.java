/*
Fried Chicken :: Nina Jiang, Lea Kwok, Lindsay Phung
APCS pd7
HW103 -- Erica's Friends, Hugo, and The One in the Middle / find minimum using
         minheap and maxheap
2022-05-19r
time spent: 1.5 hrs
*/

import java.util.ArrayList;

public class RunMed {

  private ALHeapMax lilVals;
  private ALHeapMin bigVals;

  public RunMed() {
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin();
  }

  public double getMedian() {
    double median;
    if (bigVals.size() < lilVals.size()) {
      median = lilVals.peekMax();
    } else if (bigVals.size() > lilVals.size()) {
      median = bigVals.peekMin();
    } else {
      median = (lilVals.peekMax() + bigVals.peekMin()) / 2;
    }
    return median;
  }

  public void add(Integer newVal) {
    if (lilVals.isEmpty() && bigVals.isEmpty()) {
      lilVals.add(newVal);
      return;
    }
    if (newVal < lilVals.peekMax()) {
      lilVals.add(newVal);
      return;
    } else {
      bigVals.add(newVal);
    }
    if (lilVals.size() == bigVals.size()) {
      return;
    } else {
      while ((lilVals.size()-bigVals.size()) >= 2 || (bigVals.size()-lilVals.size()) >= 2) {
        /* while (lilVals.size() != bigVals.size())
        { */
        if (lilVals.size() > bigVals.size()) {
          //int value = lilVals.remove(lilVals.size()-1);
          bigVals.add(lilVals.removeMax());
        } else {
          //int value = bigVals.remove(bigVals.size()-1);
          lilVals.add(bigVals.removeMin());
        }
        //}
      }
    }
    }

}
