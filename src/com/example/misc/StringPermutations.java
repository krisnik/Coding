package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 23/06/16.
 */
public class StringPermutations {
    public static void main(String args[]) {
        String s = "abc";

        printCombinations(s, 0, 2);
    }

    private static void printCombinations(String s, int low, int high) {

        if(low == high) {
            System.out.println(s);
        } else {
            for(int i = low ; i <= high; i++) {
                s = swap(s, low, i);
                printCombinations(s, low + 1, high);
                s = swap(s, low, i);
            }
        }
    }

    private static String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);

        char ch = sb.charAt(i);

        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);

        return sb.toString();
    }
}
