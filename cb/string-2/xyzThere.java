/*
Lea Kwok
APCS
HW28: PPMP - CodingBat String Problems
2021-11-01
time spent: 00.7
*/

/* Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
*/

public class xyzThere{
    public static boolean xyzThere(String str) {
        int x = 0;

        if (str.length() >= 3 && str.substring(0,3).equals("xyz")){
                return true;
        }

        for (x = 0; x < str.length()-3; x++){
            if(!str.substring(x,x+1).equals(".") && str.substring(x+1,x+4).equals("xyz")){
                    return true;
                 
            } 
        
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(xyzThere("abcxyz")); //expected: true
        System.out.println(xyzThere("abc.xyz")); //expected: false
        System.out.println(xyzThere("xyz.abc")); //expected: true
        System.out.println(xyzThere("abcxy")); //expected: false
        System.out.println(xyzThere("xy")); //expected: false
        System.out.println(xyzThere("x")); //expected: false
        System.out.println(xyzThere("")); //expected: false
        System.out.println(xyzThere("abc.xyzxyz")); //expected: true


    }

}