/*
Lea Kwok
APCS
HW28: PPMP - CodingBat String Problems
2021-11-01
time spent: 00.7
*/

/* Return true if the string "cat" and "dog" appear the same number of times in the given string.
*/

public class catDog{
    public static boolean catDog(String str) {
        int countCat = 0;
        int countDog = 0;
        int x;
        
        for (x = 0; x < str.length()-2; x++){
            if (str.substring(x,x+3).equals("cat")){
                countCat++;
            } 
        }
        
        for (x = 0; x < str.length()-2; x++){
            if (str.substring(x,x+3).equals("dog")){
                countDog++;
            }
        }

        if (countCat == countDog){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(catDog("catdog")); //expected: true
        System.out.println(catDog("catcat")); //expected: false
        System.out.println(catDog("1cat1cadodog")); //expected: true
    }

}