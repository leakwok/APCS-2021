public class Methods {
    public static boolean isDivisible(int n, int m){
        
        if (n % m == 0){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isTriangle(int a, int b, int c){
        

        if (a + b < c || a + c < b || b + c < a){
            return false;
        } else {
            return true;
        }

    }

    public static int ack(int d, int e){
        if (d == 0){
            return e + 1;
        } else if (d > 0 && e == 0){
            return ack(d - 1, 1);
        } else if (d > 0 && e > 0){
            return ack(d - 1, ack(d, e - 1));
        } else {
            return 0;
        }

    }

    public static void main(String[] args){
        // System.out.println(isDivisible());
        // System.out.println(isTriangle());
        System.out.println(ack(2,1));
    }


}