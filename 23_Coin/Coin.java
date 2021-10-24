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
    
  }
  
/***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
  	name = s;
  	upFace = nowFace; 
  }

/***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString(String possession, String ) {
    // "mine: " + mine
    // mine: name -- upFace
    possession = name + " -- " + upFace;
    return 
  }

}//end class

