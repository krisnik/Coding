package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 23/06/16.
 */
public class SubsetSumEquals {
    public static void main(String args[]) {
        int arr[] = {1, 5, 11, 5};

        int sum = 0;

        for(int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        findSubsetSum(arr, 0, arr.length - 1, arr[0], sum);
    }

    private static void findSubsetSum(int []arr, int i, int j, int leftSum, int rightSum ) {
        if(i == j && leftSum != rightSum) {
            System.out.print("No");
            return;
        }

        for(int k = i; k <= j; k++) {
            leftSum = leftSum + arr[k];
            rightSum = rightSum - arr[k];
            //findSubsetSum(arr );
        }
    }
}
