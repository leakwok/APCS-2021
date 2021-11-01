/* Given two strings, a and b, return the result of putting them together in the order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi".
*/

public class makeABBA {
    public static String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    public static void main(String args[]){
        
        System.out.println(makeAbba("Hi", "Bye")); //expected: "HiByeByeHi"	
        System.out.println(makeAbba("Yo", "Alice")); //expected: "YoAliceAliceYo"	
        System.out.println(makeAbba("What", "Up")); //expected: "WhatUpUpWhat"	
        System.out.println(makeAbba("aaa", "bbb")); //expected: "aaabbbbbbaaa"
        System.out.println(makeAbba("x", "y")); //expected: "xyyx"
        System.out.println(makeAbba("x", "")); //expected: "xx"
        System.out.println(makeAbba("", "y")); //expected: "yy"
        System.out.println(makeAbba("Bo", "Ya")); //expected: "BoYaYaBo"
        System.out.println(makeAbba("Ya", "Ya")); //expected: "YaYaYaYa"
    }
}