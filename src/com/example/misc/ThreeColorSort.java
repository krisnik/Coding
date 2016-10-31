package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 25/08/16.
 */
import java.util.*;
import java.lang.*;

public class ThreeColorSort {

    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            int len = s.nextInt();

            int arr[] = new int[len];

            for(int j = 0; j < len; j++) {
                arr[j] = s.nextInt();
            }

            int sorted[] = threeColorSort(arr, len);
            for(int j = 0; j < len; j++) {
                System.out.print(sorted[j]+" ");
            }

            System.out.print("\n");
        }
    }

    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static int[] threeColorSort(int arr[], int len) {
        int z = 0;
        int t = arr.length - 1;

        while(z < len && arr[z] == 0) {
            z += 1;
        }

        while(t > -1 && arr[t] == 2) {
            t -= 1;
        }

        for(int i =z ; i <= t; i++) {
            if(arr[i] == 2) {
                swap(arr, i, t);
                t -= 1;
                i -= 1;
            } else if(arr[i] == 0) {
                swap(arr, i , z);
                z += 1;
            }
        }

        return arr;
    }
}