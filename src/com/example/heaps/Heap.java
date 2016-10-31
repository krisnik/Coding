package com.example.heaps;

/**
 * Created by Krishna Nikhil Vedurumudi on 16/06/16.
 */
public interface Heap {
    public void createHeap(int arr[]);

    public int extract();

    public void insert(int num);
}

