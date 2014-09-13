/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 0);
        // left to right
        for (int i = 1, inc = 1; i < n; ++i){
            if (ratings[i]>ratings[i-1])
                candies[i] = Math.max(candies[i], inc++);
            else
                inc = 1;
        }
        //right to left
        for (int i = n-2, inc = 1; i >= 0; --i){
            if (ratings[i]>ratings[i+1])
                candies[i] = Math.max(candies[i], inc++);
            else
                inc = 1;
        }
        
        
        
        int sum = 0;
        for (int i = 0; i < n; ++i){
            sum += candies[i];
        }
        return sum+n;//at least 1 for each
    }
    
   
}
