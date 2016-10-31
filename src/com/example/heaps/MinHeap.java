package com.example.heaps;

/**
 * Created by Krishna Nikhil Vedurumudi on 16/06/16.
 */

/*
Notes : In MinHeap left value can be accessed with 2i and right value can be accessed with 2i + 1
 */
public class MinHeap implements Heap{
    private int[] array;
    private int size;
    private int position;

    public MinHeap(int size) {
        this.size = size;
        array = new int[size + 1];
        position = 0;
    }

    public void createHeap(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void insert(int num) {
        if(position == 0) {
            array[position + 1] = num;
            position = 2;
        } else {
            array[position++] = num;
            bubbleUp();
        }
    }

    /**
     * Method is used to bubbleUp so that min value always remains at the root.
     */
    private void bubbleUp() {
        int pos = position - 1; //from current position..
        while(pos > 0 && array[pos / 2] > array[pos]) {
            //if parent is greater than child, swap parent and child.
            int x = array[pos];
            array[pos] = array[pos / 2];
            array[pos/2] = x;
            pos = pos/2;
        }
    }

    /**
     * Method is used to return the min Value from the heap.
     * @return
     */
    public int extract() {
        int min = array[1]; //return the element existing at root.
        array[1] = array[position - 1]; //swap the bottom most element to the root.
        array[position - 1] = 0;
        position--;

        sinkDown(1); //perform sinkDown to minify the heap.

        return min;
    }

    private void sinkDown(int k) {
        int a = array[k];
        int smallest = k;
        if(2*k < position && array[smallest] > array[2*k]) {
            smallest = 2 * k;
        }

        if(2*k + 1< position && array[smallest] > array[2*k + 1]) {
            smallest = 2 * k + 1;
        }

        if(smallest != k) {
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
