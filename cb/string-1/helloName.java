/* Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
*/

public class helloName{

    public static String helloName(String name) {
        return "Hello " + name.toString() + "!";
    }

    public static void main(String args[]){
        System.out.println(helloName("Bob")); //expected: "Hello Bob!"
        System.out.println(helloName("Alice")); //expected: "Hello Alice!"
        System.out.println(helloName("X")); //expected: "Hello X!"
    }

}