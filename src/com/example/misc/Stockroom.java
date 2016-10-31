/* package workspace; // don't place package name! */
package com.example.misc;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Stockroom {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner input = new Scanner(System.in);

        long N = input.nextLong();
        int K = input.nextInt();

        long[] Ai = new long[K];

        for(int i = 0; i < K; i++) {
            Ai[i] = input.nextLong();
        }

        int workingCodes = getWorkingCodes(N, Ai, K);

        System.out.println(workingCodes);
    }

    private static int getWorkingCodes(long N, long[] Ai, int K) {
        HashSet<Long> workingCodes = new HashSet<>();

        for(int i = 0; i < K; i++) {
            Long temp = Ai[i];

            while(temp <= N) {
                if(!workingCodes.contains(temp)) {
                    workingCodes.add(temp);
                } else {
                    workingCodes.remove(temp);
                }
                temp += Ai[i];
            }
        }

        return workingCodes.size();
    }
}
