package com.example.system;

import java.util.*;


class Node{
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    LinkedList<Node> nodes = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);

            nodes.remove(n);
            nodes.addFirst(n);

            return n.value;
        }

        return -1;
    }



    public void set(int key, int value) {
        if(!map.containsKey(key)) {

            Node n = new Node(key, value);
            map.put(key, n);
            nodes.addFirst(n);

            if(nodes.size() > this.capacity) {
                Node end = nodes.getLast();
                nodes.removeLast();
                map.remove(end.key);
            }
        } else {
            Node n = map.get(key);
            nodes.remove(n);
            n.value = value;
            nodes.addFirst(n);
        }
    }
}