package com.example.hi1029.Tenta.T2306.upg4;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {  {1,5,4,7,8,3,1},
                            {2,6,3,4,7,1,5},
                            {3,5,1,9,1,7,1},
                            {1,3,1,4,5,8,2},
                            {3,1,8,3,1,2,1}};
        System.out.println(maxSum(matrix,1));
    }
    private static int maxSum(int[][] matrix, int startCol) {
        if(startCol >= matrix[0].length || startCol < 0)
            return -1;
        return maxSum(matrix, 0, startCol);
    }

    private static int maxSum(int[][] matrix, int row, int col) {
        if(col < 0 || row < 0 || row >= matrix.length || col >= matrix[row].length)
            return Integer.MIN_VALUE;

        if(row == matrix.length - 1)
            return matrix[row][col];

        int jumpLeft = maxSum(matrix, row + 1, col -1);
        int jumpDown = maxSum(matrix, row + 1, col);
        int jumpRight = maxSum(matrix, row + 1, col + 1);

        return matrix[row][col] + Math.max(jumpLeft, Math.max(jumpDown, jumpRight));
    }

}
