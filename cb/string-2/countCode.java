/*
Lea Kwok
APCS
HW28: PPMP - CodingBat String Problems
2021-11-01
time spent: 00.7
*/

/* Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
*/

public class countCode{
    public static int countCode(String str) {
        int counter = 0;
        int x;
        for(x = 0; x < str.length()-3; x++){
            if(str.substring(x,x+2).equals("co") && str.substring(x+3,x+4).equals("e")){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countCode("aaacodebbb")); //expected: 1
        System.out.println(countCode("codexxcode")); //expected: 2
        System.out.println(countCode("cozexxcope")); //expected: 2
    }
}