public class Loops {
    public static double power(double x, int n){
        double num = 1;
        for (int i = 1; i < n; i++){
            num = x * num;
        }
        return num;
    }

    public static int factorial(int a){
        int fact = 1;
        for (int i = 0; i < a; i++){
            fact = a * factorial(a-1);
        }
        return fact;
    }

    public static double myexp(int x, int n){
        factorial(x);
    }

    public static double check(double x){
        return x;
        return myexp(x);
        return Math.exp(x);
    } 



    public static void main(String[] args){
        // System.out.println(power(3,2));
        // System.out.println(factorial(3));
    }

}