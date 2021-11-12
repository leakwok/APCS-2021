/*
Lea Kwok
APCS
HW28: PPMP - CodingBat String Problems
2021-11-01
time spent: 00.7
*/

/* Return the number of times that the string "hi" appears anywhere in the given string.
*/

public class countHi {
    
    public static int countHi(String str) {
        int counter = 0;
        int x;
        for (x = 0; x < str.length()-1; x++){
            if (str.substring(x,x+2).equals("hi")){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countHi("abc hi ho")); //expected: 1
        System.out.println(countHi("ABChi hi")); //expected: 2
        System.out.println(countHi("hihi")); //expected: 2
    }

}