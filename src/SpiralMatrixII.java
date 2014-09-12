/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] A = new int[n][n];
        int begin = 0, end = n-1;
        int num = 1;
        while(begin < end){
            for (int col = begin; col < end; ++col) A[begin][col] = num++;
            for (int row = begin; row < end; ++row) A[row][end] = num++;
            for (int col = end; col > begin; --col) A[end][col] = num++;
            for (int row = end; row > begin; --row) A[row][begin] = num++;
            ++begin;
            --end;
        }
        if (begin == end) A[begin][end] = num;
        return A;
    }
}
