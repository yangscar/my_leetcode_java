/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/public class Solution {
    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        int i = 0;
        while (i < height.length){
            if (q.isEmpty() || height[q.peekLast()] <= height[i])
                q.offerLast(i++);
            else{
                int pos = q.removeLast();
                maxArea = Math.max(maxArea, 
                    (q.isEmpty()? i : i-q.peekLast()-1)*height[pos]);
            }
        }
        
        while(!q.isEmpty()){
            int pos = q.removeLast();
            maxArea = Math.max(maxArea, 
                    (q.isEmpty()? i : i-q.peekLast()-1)*height[pos]);
        }
        return maxArea;
    }
}
