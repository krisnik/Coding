package com.example.trees;

/**
 * Created by Krishna Nikhil Vedurumudi on 18/08/16.
 */

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class ISBST
{
    int prev = Integer.MIN_VALUE;
    
    int isBST(Node root)
    {
        // Your code here
        if(root != null) {
            if(isBST(root.left) == 0) {
                return 0;
            }

            if(root.data >= prev) {
                prev = root.data;
            } else {
                return 0;
            }

            if(isBST(root.right) == 0) {
                return 0;
            }
        }

        return 1;
    }
}