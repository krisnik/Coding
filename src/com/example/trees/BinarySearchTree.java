package com.example.trees;


import apple.laf.JRSUIUtils;

/**
 * Created by Krishna Nikhil Vedurumudi on 17/08/16.
 */

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {

    public TreeNode insert(TreeNode root, int data){
        if(root == null) {
            root = new TreeNode(data);
        } else {
            if(root.data == data) {
                //duplicates will not be inserted.
                return root;
            } else if(root.data > data) {
                //insert to the left of root.
                root.left = insert(root.left, data);
            } else {
                //insert to the right of root.
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        if(root != null) {
            if(root.data == key) {
                if(root.left == null) {
                    return root.right;
                } else if(root.right == null) {
                    return root.left;
                } else {
                    TreeNode nextNode = findMin(root.right);
                    root = delete(root, nextNode.data);
                    root.data = nextNode.data;
                }
            } else {
                if(root.data > key) {
                    root.left = delete(root.left, key);
                } else {
                    root.right = delete(root.right, key);
                }
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if(root.left == null) {
            return root;
        } else {
            return findMin(root.left);
        }
    }

    public TreeNode search(TreeNode root, int key){
        if(root != null) {
            if (root.data == key) {
                return root;
            } else {
                if (root.data > key) {
                    return search(root.left, key);
                } else {
                    return search(root.right, key);
                }
            }
        }
        return null;
    }

    public void printInOrder(TreeNode root) {
        if(root != null) {
            printInOrder(root.left);
            System.out.print(" "+root.data);
            printInOrder(root.right);
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();

        TreeNode root = null;
        root = bst.insert(root, 5);
        root = bst.insert(root, 8);
        root = bst.insert(root, 3);
        root = bst.insert(root, 7);
        root = bst.insert(root, 1);
        root = bst.insert(root, 9);
        root = bst.insert(root, 4);

        System.out.println("After Inserting the tree so far is ");
        bst.printInOrder(root);

        root = bst.delete(root, 4);
        root = bst.delete(root, 8);
        root = bst.delete(root, 14);

        System.out.println("\nAfter deleting the tree is ");
        bst.printInOrder(root);
    }
}
