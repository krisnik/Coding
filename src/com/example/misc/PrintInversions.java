package com.example.misc;

import java.util.ArrayList;

/**
 * Created by Krishna Nikhil Vedurumudi on 22/06/16.
 */

class Node {
    int i;
    int j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String toString() {
        return "( " + i + ", " + j + ")";
    }
}

public class PrintInversions {

    public int countInversions(ArrayList<Integer> a) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();


        int index = 1;
        int count = 0;

        numbers.add(a.get(0));

        while(index < a.size() ) {
            System.out.print("the array is ");
            for(Integer i : numbers) {
                System.out.print(i + " ");
            }

            System.out.print("\n");

            int temp = a.get(index);

            if(temp < numbers.get(numbers.size() - 1)) {
                int tempCount = 0;
                int i = 0;

                while(i < numbers.size()) {
                    if(numbers.get(i) > temp) {
                        tempCount = numbers.size() - i;
                        numbers.add(i, temp);
                        break;
                    }
                    i++;
                }
                count += tempCount;
            } else {
                numbers.add(temp);
            }

            index += 1;
        }

        return count;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(1);

        int count = new PrintInversions().countInversions(arr);

        System.out.println("inversions "+count);
    }
}

