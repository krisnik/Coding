package com.example.linkedlists;

/**
 * Created by Krishna Nikhil Vedurumudi on 21/06/16.
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode newNode = null;
        ListNode result = null;

        ListNode atemp = a;
        ListNode btemp = b;

        while(atemp != null && btemp != null) {
            ListNode node;
            if(atemp.val < btemp.val) {
                node = new ListNode(atemp.val);
                atemp = atemp.next;
            } else {
                node = new ListNode(btemp.val);
                btemp = btemp.next;
            }
            if(result == null) {
                result = node;
                newNode = result;
            } else {
                newNode.next = node;
                newNode = newNode.next;
            }
        }

        while(atemp != null) {
            ListNode node = new ListNode(atemp.val);
            if(result == null) {
                result = node;
                newNode = result;
            } else {
                newNode.next = node;
                newNode = newNode.next;
            }
            atemp = atemp.next;
        }

        while(btemp != null) {
            ListNode node = new ListNode(btemp.val);
            if(result == null) {
                result = node;
                newNode = result;
            } else {
                newNode.next = node;
                newNode = newNode.next;
            }
            btemp = btemp.next;
        }

        return result;

    }

}

