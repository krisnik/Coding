package com.example.misc;

/**
 * Created by Krishna Nikhil Vedurumudi on 30/08/16.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class StreamValidator {

    List<Integer> invalidBrackets;

    Stack<Integer> openBrackets;

    Integer index;

    public StreamValidator() {
        this.invalidBrackets = new ArrayList<>();

        this.openBrackets = new Stack<>();

        this.index = 0;
    }

    public void consumeBracket(char bracket) {
        this.index += 1;
        if(bracket == '(') {
            openBrackets.push(this.index);
        } else {
            if(!this.openBrackets.empty()) {
                this.openBrackets.pop();
            } else {
                invalidBrackets.add(index);
            }
        }
    }

    public boolean isValid() {
        if(!invalidBrackets.isEmpty()) {
            return false;
        }

        return openBrackets.empty();
    }

    public List<Integer> getInvalidIndexList() {
        List<Integer> invalidIndexes = new ArrayList<>();

        for(Integer ind : invalidBrackets) {
            invalidIndexes.add(ind);
        }

        for(Integer ind : openBrackets) {
            invalidIndexes.add(ind);
        }

        return invalidIndexes;
    }
}

class Result {
    int maxSum;
    int startIndex;
    int endIndex;

    Result(int maxSum, int startIndex, int endIndex) {
        this.maxSum = maxSum;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

}

class MaxSubArray {
    public Result findMaxSum(int arr[]) {
        int maxOverall = arr[0];

        int currentMax = arr[0];

        int startIndex = 0;

        int endIndex = 0;

        int tempStartIndex = 0;

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] > currentMax + arr[i]) {
                currentMax = arr[i];
                tempStartIndex = i;
            } else {
                currentMax += arr[i];
            }

            if(maxOverall <  currentMax) {
                endIndex = i;
                startIndex = tempStartIndex;
                maxOverall =  currentMax;
            }

        }

        return new Result(maxOverall, startIndex, endIndex);
    }
}
