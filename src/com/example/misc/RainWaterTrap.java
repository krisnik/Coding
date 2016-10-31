package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 22/08/16.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class RainWaterTrap {
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

            int water = waterTrap(arr);
            System.out.println(water);
        }
    }

    private static int waterTrap(int arr[]) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];

        for(int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        for(int i = arr.length - 2; i > -1; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int totalWater = 0;
        for(int i =0; i < arr.length; i++) {
            totalWater += Math.min(left[i], right[i]) - arr[i];
        }

        return totalWater;
    }
}