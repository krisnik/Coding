package com.example.misc;

import java.util.*;
/**
 * Created by Krishna Nikhil Vedurumudi on 23/06/16.
 */

public class IntegerPermutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        permute(output, a, 0, a.size()- 1);

        return output;
    }

    public void permute(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> arr, int low, int high) {
        if(low == high) {
            output.add(arr);
        } else {
            for(int i = low;i <= high; i++) {
                swap(arr, low, i);
                permute(output, arr, low+1, high);
                swap(arr, low, i);
            }
        }
    }

    public void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        ArrayList<ArrayList<Integer>> output = new IntegerPermutations().permute(arr);

        for(ArrayList<Integer> a: output) {
            System.out.print("[");
            for(Integer i : a) {
                System.out.print(a + " ");
            }
            System.out.println("]");
        }
    }
}