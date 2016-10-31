package com.example.heaps;

/**
 * Created by Krishna Nikhil Vedurumudi on 16/06/16.
 */

class MinHeapNode {
    int value;
    int x;
    int y;
}
public class HeapQuestions {

    /**
     * Here Extra array for MinHeapnodes is used. Instead if MinHeap is created for MinHeapNode, the solution
     * will be much simpler
     * @param arr
     * @param lengthOfArrays
     */
    public static void mergeKSortedArrays(int arr[][], int lengthOfArrays) {
        int output[] = new int[lengthOfArrays * arr.length];

        int outputIndex = 0;

        int k = arr.length;
        Heap minHeap = new MinHeap(k);

        MinHeapNode nodes[] = new MinHeapNode[k];

        for(int i = 0; i< k; i++) {
            nodes[i] = new MinHeapNode();
        }
        //initialize the min heap with zeroth elements of all the arrays
        for(int i = 0; i < k; i++) {
            minHeap.insert(arr[i][0]);
            nodes[i].value = arr[i][0];
            nodes[i].x = i;
            nodes[i].y = 0;
        }

        while(true) {
            //get the minimal element from the min heap.
            int min = minHeap.extract();
            output[outputIndex++] = min;

            //if all the elements are stored in output, break..
            if(outputIndex == lengthOfArrays * k) {
                break;
            }

            //replace the next element from where we have removed.
            for(int i = 0; i < k; i++) {
                if(nodes[i].value == min) {
                    //replace the node with next.
                    int x = nodes[i].x;
                    int y = nodes[i].y;
                    y++;

                    if(y < lengthOfArrays) {
                        minHeap.insert(arr[x][y]);
                        nodes[i].value = arr[x][y];
                        nodes[i].y = y;
                    }
                    break;
                }
            }

        }

        System.out.println("After merging sorted arrays .. ");

        for(int i = 0; i < output.length; i++) {
            System.out.print(output[i] + "\t");
        }

    }
}
