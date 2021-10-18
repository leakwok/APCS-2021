/**
   Clyde "Thluffy" Sinclair
   APCS pd0
   HW18 -- building a more meaningful class
   2021-10-18

   instance variables for storing...
   account holder's full name
   account password
   4-digit PIN
   9-digit account number
   account balance

   and methods for...
   setting each attribute
   printing out all of an account’s info at once
   depositing money
   withdrawing money
**/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    pin = newPin;
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    acctNum = newAcctNum;
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public void withdraw( double withdrawAmount ) {
    balance = balance - withdrawAmount;
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args ) {
    BankAccount ba = new BankAccount();

    // test setName()
    System.out.println(ba.setName("DLR"));
    ba.setName("RLD");
    System.out.println(ba.name);
    System.out.println(ba.toString());

    // test setPasswd()
    System.out.println(ba.setPasswd("abcdefghi"));
    ba.setPasswd("6544635");
    System.out.println(ba.passwd);
    System.out.println(ba.toString());

    // test setPin()
    short newPin = 2344;
    System.out.println(ba.setPin(newPin));
        // can a pin be more than 4 digits? (no)
        // newPin = 543444;
        // ba.setPin(newPin);
        // System.out.println(ba.pin);
    // can a pin be less than 4 digits? (yes)
    newPin = 234;
    ba.setPin(newPin);
    System.out.println(ba.pin);
    System.out.println(ba.toString());

    //test setAcctNum()
    System.out.println(ba.setAcctNum(123456789));
    ba.setAcctNum(3424);
    System.out.println(ba.acctNum);
        // can acctNum be more than 9 digits? (no)
        // ba.setAcctNum(0123456789);
        // System.out.println(ba.acctNum);
        // System.out.println(ba.toString());

    // test setBalance()
    System.out.println(ba.setBalance(333));
    ba.setBalance(234.34);
    System.out.println(ba.balance);
    System.out.println(ba.toString());

    // test deposit()
    ba.deposit(3434);
    System.out.println(ba.balance);
    ba.deposit(342.34);
    System.out.println(ba.balance);
    System.out.println(ba.toString());

    // test withdraw()
    ba.withdraw(5000);
    System.out.println(ba.balance);
    // can withdrawl amount be neg? (yes)
    ba.withdraw(-343);
    System.out.println(ba.balance);
    ba.withdraw(43243.43);
    System.out.println(ba.balance);
    System.out.println(ba.toString());

    System.out.println(ba.toString());



  }//end main()

}//end class BankAccount
