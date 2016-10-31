package com.example.trees;

/**
 * Created by Krishna Nikhil Vedurumudi on 25/08/16.
 */
/**
 * Definition for binary tree
 *
 */

class Result {
    int val = Integer.MIN_VALUE;
}
public class MaximumSumPath {

    static int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode a) {
        if(a != null) {

            Result res = new Result();

            test(a, res);

            return res.val;
        }

        return Integer.MIN_VALUE;
    }

    public int test(TreeNode a, Result res) {
        if(a != null) {

            int leftSum = test(a.left, res);
            int rightSum = test(a.right, res);

            int singleMax = Math.max( Math.max(leftSum, rightSum) + a.data, a.data);

            int totalMax = Math.max(leftSum + rightSum + a.data, singleMax);

            res.val = Math.max(totalMax, res.val);

            return singleMax;
        }

        return 0;
    }
}
