public class Cereal {
    String name;
    char type;
    int calorie, protein, fat, sodium, fiber, sugar, potassium, vitamin, shelf;
    double carb, weight, cup;
    double  rating;
  
    public Cereal(){
      name = "";
      //type = '';
      calorie = protein = fat = sodium = fiber = sugar = potassium = vitamin = shelf = 0;
      carb = weight = cup = 0.0;
      //rating = 0.0;
    }
  
    public Cereal(String n, char t, int cal, int pro, int ft, int sod, int fib, int sug, int pot, int vit, int she, double car, double wei, double cp, double rat){
      name = n;
      type = t;
      calorie = cal;
      protein = pro;
      fat = ft;
      sodium = sod;
      fiber = fib;
      sugar = sug;
      potassium = pot;
      vitamin = vit;
      shelf = she;
      carb = car;
      weight = wei;
      cup = cp;
      rating = rat;
    }
  
    public String getName(){
      return name;
    }
  
    public char getType() {
      return type;
    }
  
    public int getCal() {
      return calorie;
    }
  
    public int getPro() {
      return protein;
    }
  
    public int getFat() {
      return fat;
    }
  
    public int getSodium() {
      return sodium;
    }
  
    public int getFib() {
      return fiber;
    }
  
    public int getSugar() {
      return sugar;
    }
  
    public int getPota() {
      return potassium;
    }
  
    public int getVita() {
      return vitamin;
    }
  
    public int getShelf() {
      return shelf;
    }
  
    public double getCarb() {
      return carb;
    }
  
    public double getWeight() {
      return weight;
    }
  
    public double getCup() {
      return cup;
    }
  
    public double getRating() {
      return rating;
    }
  
    public String toString() {
      String retval = "";
      retval += "Cereal: " + name;
      retval += "\nType: " + type;
      retval += "\ncalorie: " + calorie;
      retval += "\nprotein: " + protein;
      retval += "\nfat: " + fat;
      retval += "\nSodium: " + sodium;
      retval += "\npotassium: " + potassium;
      retval += "\nvitamin: " + vitamin;
      retval += "\nshelf life: " + shelf;
      retval += "\ncarbs: " + carb;
      retval += "\nweight: " + weight;
      retval += "\nCups: " + cup;
      retval += "\nRating: " + rating;
  
      return retval;
    }
  
    public static void main(String[] args) {
      Cereal turtle = new Cereal("100% Bran", 'C', 70, 4, 1, 130, 10, 5, 6, 280, 25, 3, 1, 0.33, 68.402973);
      System.out.println(turtle);
      System.out.println(turtle.getRating());
    }
  
  }