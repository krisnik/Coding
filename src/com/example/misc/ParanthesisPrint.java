package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 23/06/16.
 */
public class ParanthesisPrint {

    public static void main(String args[]) {
        int count = 3;

        char arr[] = new char[4];

        printValidParanthesis(arr, 0, 0, 0, 2);
    }

    private static void printValidParanthesis(char arr[], int pos, int leftCount, int rightCount, int count) {
        if(rightCount == count) {
            System.out.println(new String(arr));
        } else {
            if(rightCount < leftCount) {
                arr[pos] = '}';
                printValidParanthesis(arr, pos + 1, leftCount, rightCount + 1, count);
            }
            if(leftCount < count) {
                arr[pos] = '{';
                printValidParanthesis(arr, pos + 1, leftCount + 1, rightCount, count);
            }
        }
    }
}
