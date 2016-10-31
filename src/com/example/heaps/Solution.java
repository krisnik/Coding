package com.example.heaps;

import java.util.List;
import java.util.ArrayList;
import java.util.jar.Pack200;

/**
 * Created by Krishna Nikhil Vedurumudi on 17/06/16.
 */

/*
public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int carry = 0;

        int flag = 1;
        //remove trailing zeroes.
        for(int i = 0; i < a.size() - 1; i++) {
            if(a.get(i) == 0) {
                a.remove(i);
                i--;
            }
            else break;
        }

        for(int i = a.size() - 1; i >= 0; i--) {

            int num = a.get(i);

            num = num + carry + flag;

            flag = 0;

            carry = num / 10;

            num = num % 10;

            a.set(i, num);
        }

        if(carry == 1) {
            a.add(0, 1);
        }

        return a;
    }

    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(6);
        a.add(0);
        a.add(6);
        a.add(4);
        a.add(8);
        a.add(8);
        a.add(1);

        //0, 6, 0, 6, 4, 8, 8, 1
        ArrayList<Integer> soln = new Solution().plusOne(a);

        System.out.println("soln ");

        for(Integer i : soln) {
            System.out.println(i+",");
        }
    }
}
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();

        //Initial point..
        int x = 0;
        int y = 0;

        int rows = a.size();
        int cols = a.get(0).size();

        System.out.println("rows "+rows+" columns "+cols);

        output.add(new ArrayList<Integer>());
        output.get(0).add(a.get(0).get(0));


        while(true) {

            if(y < cols -1) {
                ArrayList<Integer> array = new ArrayList<Integer>();
                int x1 = x;
                int y1 = y;

                y1++;
                while(y1 > -1 && x1 < rows) {

                    array.add(a.get(x1).get(y1));
                    y1--;
                    x1++;
                }

                output.add(array);
                y++;
            } else if(x < rows - 1) {
                ArrayList<Integer> array = new ArrayList<Integer>();
                int x1 = x;
                int y1 = y;

                x1++;

                while(x1 < rows && y1 > -1) {

                    array.add(a.get(x1).get(y1));
                    x1++;
                    y1--;
                }
                output.add(array);
                x++;
            }

            if(x == rows - 1 && y == cols - 1) {
                break;
            }

        }

        return output;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> in= new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);

        input.add(in);
        input.add(in);
        input.add(in);

        ArrayList<ArrayList<Integer>> output = new Solution().diagonal(input);
        for(ArrayList<Integer> li : output) {
            System.out.print("\n");
            for(Integer i : li) {
                System.out.print("  "+i);
            }
        }
    }
}

class MaxHeap1 {

    int size;
    String array[];
    int position;

    public MaxHeap1(int size) {
        this.size = size;
        array = new String[size + 1];

        for(int i = 0; i < size + 1; i++) {
            array[i] = new String();
        }
        array[0] = "99999999999999";
        position = 0;
    }

    public int myCompareTo(String n1, String n2) {
        int len1= n1.length();
        int len2 = n2.length();

        if(len1 == len2) {
            return n1.compareTo(n2);
        } else {
            if(len1 < len2) {
                int substrCompare = n1.compareTo(n2.substring(0, len1));

                if(substrCompare == 0) {
                    if(n2.charAt(len1) > n1.charAt(len1 - 1)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                return substrCompare;
            } else {
                int substrCompare = n2.compareTo(n1.substring(0, len2));

                if(substrCompare == 0) {
                    if(n1.charAt(len2) > n2.charAt(len2 - 1)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                return substrCompare;
            }
        }
    }
    public void createHeap(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void insert(int num) {
        if(position == 0) {
            array[1] = "" + num;
            position = 2;
        } else {
            array[position++] = "" + num;
            bubbleUp();
        }
    }

    public void bubbleUp() {
        int pos = position - 1;
        while(pos > 0 && myCompareTo(array[pos/2], array[pos]) < 0) {
            String temp = array[pos];
            array[pos] = array[pos / 2];
            array[pos / 2] = temp;
            pos = pos / 2;
        }
    }

    public String extract() {
        String max = array[1];

        array[1] = array[position - 1];
        array[position - 1] = "00000000000";
        position--;

        sinkDown(1);
        return max;
    }

    public void sinkDown(int k) {

        String a = array[k];
        int largest = k;

        if(2*k < position && myCompareTo(array[largest], array[2 * k]) < 0) {
            largest = 2 * k;
        }

        if(2*k + 1< position && myCompareTo(array[largest], array[2 * k + 1]) < 0) {
            largest = 2 * k + 1;
        }

        if(largest != k) {
            swap(k, largest);
            sinkDown(largest);
        }
    }

    private void swap(int a, int b) {
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
