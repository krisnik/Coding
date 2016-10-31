package com.example.linkedlists;

/**
 * Created by Krishna Nikhil Vedurumudi on 21/06/16.
 */
/**
 * Definition for singly-linked list.
 *
 */

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x; next = null;
    }
}

public class FindMergeOfLinkedLists {

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int len1 = 0;
        int len2 = 0;

        ListNode x = a;

        while(x != null) {
            len1 += 1;
            x = x.next;
        }

        x = b;
        while(x != null) {
            len2 += 1;
            x = x.next;
        }

        ListNode aTemp = a;
        ListNode bTemp = b;
        if(len1 > len2) {
            for(int i = 0; i < (len1 - len2); i++) {
                aTemp = aTemp.next;
            }
        } else if(len1 < len2) {
            for(int i = 0; i< (len2 - len1); i++) {
                bTemp = bTemp.next;
            }
        }

        while(aTemp != null && bTemp != null) {
            if(aTemp == bTemp) {
                return aTemp;
            }

            aTemp = aTemp.next;
            bTemp = bTemp.next;
        }

        return null;
    }
}