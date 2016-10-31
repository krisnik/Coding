package com.example.trees;

/**
 * Created by Krishna Nikhil Vedurumudi on 18/08/16.
 */

public class ISBalancedBST {

    public int isBalanced(TreeNode a) {
        if(a != null) {

            int lh = checkHeight(a.left);
            int rh = checkHeight(a.right);

            if(Math.abs(lh - rh) > 1) {
                return 0;
            }

            int left = isBalanced(a.left);
            int right = isBalanced(a.right);

            return left & right;
        }

        return 1;

    }

    private int checkHeight(TreeNode root) {
        if(root != null) {
            int left = 1 + checkHeight(root.left);
            int right = 1 + checkHeight(root.right);

            return Math.max(left, right);
        }

        return 1;
    }
}
