/**
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.


 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int ans = 0;
        Map<Double, Integer> slope_count = new HashMap();
        for (int i = 0; i < points.length-1; ++i){
            slope_count.clear();
            int n_samePoint = 0;
            int n_max = 1;
            for (int j = i+1; j < points.length; ++j){
                double slope;
                if (points[i].x == points[j].x){
                    slope = Double.MAX_VALUE;
                    if (points[i].y == points[j].y){
                        n_samePoint ++;
                        continue;
                    }
                }else if (points[i].y == points[j].y){
                    slope = 0;
                }else{
                    slope = 1.0*(points[i].y-points[j].y)/
                        (points[i].x-points[j].x);
                }
                
                int count = 0;
                if (!slope_count.containsKey(slope))
                    slope_count.put(slope,2);
                else
                    slope_count.put(slope,slope_count.get(slope)+1);
                
                n_max = Math.max(n_max, slope_count.get(slope));
                
            }
            
            ans = Math.max(ans, n_max+n_samePoint);
        }
        
        return ans;
    }
}
