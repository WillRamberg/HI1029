package com.example.hi1029.Tenta.T2103.upg4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindLargest {

    public static int largestSum(int[] arr) {
        if (arr.length < 4) {
            return arr[0];
        }
        return largestSum(arr, 0);
    }

    public static int largestSum(int[] arr, int index) {
        if (index > arr.length - 1)
            return 0;

        int jump3 = largestSum(arr, index + 3);
        int jump5 = largestSum(arr, index + 5);

        return arr[index] + Math.max(jump3, jump5);
    }

    public static int largestSumWidth(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, arr[0]});
        int maxSum = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            int index = temp[0], sum = temp[1];
            if (sum > maxSum)
                maxSum = sum;

            if(index + 3 < arr.length) {
                stack.push(new int[]{index + 3, sum + arr[index + 3]});
            }
            if(index + 5 < arr.length) {
                stack.push(new int[]{index + 5, sum + arr[index + 5]});
            }
        }
        return maxSum;
    }
}
