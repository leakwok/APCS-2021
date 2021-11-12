/*
Lea Kwok
APCS
HW28: PPMP - CodingBat String Problems
2021-11-01
time spent: 00.7
*/

/*Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.
*/

public class endOther{
    public static boolean endOther(String a, String b) {
        int x;
        if(a.length() > b.length()){

                if(a.substring(a.length()-b.length()).toLowerCase().equals(b.toLowerCase()))
                {
                    return true;
                } 
            
        } else {

                if(b.substring(b.length()-a.length()).toLowerCase().equals(a.toLowerCase()))
                {
                    return true;
                } 

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(endOther("Hiabc", "abc")); //expected: true
        System.out.println(endOther("AbC", "HiaBc")); //expected: true
        System.out.println(endOther("abc", "abXabc")); //expected: true
        System.out.println(endOther("Hiabc", "abcd")); //expected: false
        System.out.println(endOther("Hiabcx", "bc")); //expected: false
        System.out.println(endOther("yz", "12xz")); //expected: false
    }

}