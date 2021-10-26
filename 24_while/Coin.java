/***
 Team Nissan Lamp: Joshua Gao, Lea Kowk
 APCS
 HW23 -- What Does Equality Look Like?
 2021-10-24
 time spent: 0.7

 DISCO:
  n/a
 QCC:
  how can we condense if statements? 
 ***/

import java.lang.Math;

public class Coin {

  //attributes aka instance vars
	private double value;
	private String upFace;
	private String name;
	private int flipCtr;
	private int headsCtr;
	private int tailsCtr;
	private double bias;


  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    this.toString();
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    if (s == "penny" || s == "dime" || s == "nickel" || s == "quarter" || s == "dollar" || s == "half-dollar") { // from David Chan's code
      name = s;
      upFace = "heads";
    } else if (s == "Penny" || s == "Dime" || s == "Nickel" || s == "Quarter" || s == "Dollar" || s == "Half-dollar"){
      name = s;
      upFace = "heads";
    } 
    this.toString();
  }
  
/***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
  	name = s;
  	upFace = nowFace; 
    this.toString();
  }
  
// Accessors...
  // ----------------------------
  public String getUpFace() {
	return upFace;
  }

  public int getFlipCtr() {
	return flipCtr;
  }

  public double getValue() {
	return value;
  }

  public int getHeadsCtr() {
	return headsCtr;
  }

  public int getTailsCtr() {
	return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
	if (s.equals("penny")) {
		value = 0.01;
	} else if (s.equals("nickel")) {
		value = 0.05;
	} else if (s.equals("dime")) {
  		value = 0.10;
  	} else if (s.equals("quarter")) {
  		value = 0.25;
  	} else if (s.equals("half dollar")) {
  		value = 0.50;
  	} else if (s.equals("dollar")) {
  		value = 1.00;
  	}
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
	if ((s.equals("heads") || s.equals("tails")) && 1.0 >= d && d >= 0.0) {
		upFace = s;
		flipCtr = 0;
		headsCtr = 0;
		tailsCtr = 0;
		bias = d;
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    this.bias = Math.random();
    
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
      if (other != null && other.upFace.equals("heads")){
          return true;
      } else if (other != null && other.upFace.equals("tails")){
          return true;
      } else {
          return false;
      }
  }
  
/***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    // "mine: " + mine
    // mine: name -- upFace
    // possession = name + " -- " + upFace;
    return name + " -- " + upFace;
  }

}//end class

