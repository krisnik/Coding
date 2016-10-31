package com.example.heaps;

public class MaxHeap {

    int size;
    int array[];
    int position;

    public MaxHeap(int size) {
        this.size = size;
        array = new int[size + 1];
        array[0] = Integer.MAX_VALUE;
        position = 0;
    }

    public void createHeap(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void insert(int num) {
        if(position == 0) {
            array[1] = num;
            position = 2;
        } else {
            array[position++] = num;
            bubbleUp();
        }
    }

    public void bubbleUp() {
        int pos = position - 1;
        while(pos > 0 && array[pos/2] < array[pos]) {
            int temp = array[pos];
            array[pos] = array[pos / 2];
            array[pos / 2] = temp;
            pos = pos / 2;
        }
    }

    public int extract() {
        int max = array[1];

        array[1] = array[position - 1];
        array[position - 1] = 0;
        position--;

        sinkDown(1);
        return max;
    }

    public void sinkDown(int k) {

        int a = array[k];
        int largest = k;

        if(2*k < position && array[largest] < array[2*k]) {
            largest = 2 * k;
        }

        if(2*k + 1< position && array[largest] < array[2*k + 1]) {
            largest = 2 * k + 1;
        }

        if(largest != k) {
            swap(k, largest);
            sinkDown(largest);
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}