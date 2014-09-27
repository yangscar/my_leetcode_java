/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length < 1) return result;
        //[L,H]
        int xL = 0, xH = matrix[0].length - 1;
        int yL = 0, yH = matrix.length -1;
        while(true){
            // LeftTop --> RightTop 
            for (int x = xL; x <= xH; ++x) result.add(matrix[yL][x]);
            if (++yL > yH) break;
            // RightTop --> RightDown
            for (int y = yL; y <= yH; ++y) result.add(matrix[y][xH]);
            if (xL > --xH) break;
            // RightDown --> LeftDown
            for (int x = xH; x >= xL; --x) result.add(matrix[yH][x]);
            if (yL > --yH) break;
            // LeftDown --> LeftTop
            for (int y = yH; y >= yL; --y) result.add(matrix[y][xL]);
            if (++xL > xH) break;
            
        }
        return result;
    }
}
