package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 17/08/16.
 */
import java.util.*;
import java.lang.*;


class FindMissingElement {

    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            int len = s.nextInt();

            int arr[] = new int[len + 1];

            for(int j = 1; j < len; j++) {
                arr[j] = s.nextInt();
            }

            int missingElement = findMissingElement(arr, len);

            System.out.println(missingElement);
        }
    }

    public static int findMissingElement(int arr[], int len) {
        int i = 1;
        //System.out.println("arr size "+arr.length);
        int count = 0;
        while(count < arr.length - 1) {
            int next = arr[i];
            if(next == -1) {
                i += 1;
            }else if(next == i){
                arr[i] = -1;
                i += 1;
            }else {
                i = next;
                arr[i] = -1;
            }
            count += 1;
        }

        for(i = 1; i < arr.length; i++) {
            if(arr[i] != -1) {
                return i;
            }
        }
        return - 1;
    }
}