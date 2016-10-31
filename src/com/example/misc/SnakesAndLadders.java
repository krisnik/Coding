package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 19/07/16.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakesAndLadders {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        System.out.println("execution started.. enter input.. ");
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for(int test = 0; test < t; test++) {
            HashMap<Integer, Integer> ladders = new HashMap<>();
            int ladderCount = s.nextInt();
            for(int l = 0; l < ladderCount; l++) {
                Integer start = s.nextInt();
                Integer end = s.nextInt();
                ladders.put(start, end);
            }

            HashMap<Integer, Integer> snakes = new HashMap<>();
            int snakesCount = s.nextInt();
            for(int sC = 0; sC < snakesCount; sC++) {
                Integer start = s.nextInt();
                Integer end = s.nextInt();
                snakes.put(start, end);
            }
            HashSet<Integer> pos = new HashSet<>();
            pos.add(1);
            int n = snakesAndLadders(ladders, snakes, pos);

            System.out.println(n);


        }
    }

    private static int snakesAndLadders(HashMap<Integer, Integer> ladders, HashMap<Integer, Integer> snakes, HashSet<Integer> positions) {
        Integer hundred = 100;

        int steps = 0;
        while(!positions.contains(hundred)) {
            HashSet<Integer> oldPositions = positions;
            positions = new HashSet<>();

            for(Integer i : oldPositions) {
                for(Integer dice = 1; dice < 7; dice++) {
                    Integer nextPos = i + dice;

                    if (!snakes.containsKey(nextPos)) {
                        if (ladders.containsKey(nextPos)) {
                            positions.add(ladders.get(nextPos));
                        } else {
                            positions.add(nextPos);
                        }
                    }

                }
            }
            steps += 1;
        }

        return steps;
    }
}