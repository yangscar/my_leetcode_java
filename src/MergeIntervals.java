/**
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                if (a.start == b.start)
                    return a.end - b.end;
                else
                    return a.start - b.start;
            }
        });
        List<Interval> ans = new ArrayList<Interval>();
        Interval preInterval=null;
        for (Interval i:intervals){
            if (preInterval == null){
                preInterval = new Interval(i.start, i.end);
            }else {
                if (preInterval.end < i.start){
                    ans.add(preInterval);
                    preInterval = new Interval(i.start, i.end);
                }else{
                    preInterval.end = Math.max(i.end,preInterval.end);
                }
            }
        }
        if (preInterval != null) ans.add(preInterval);
        
        return ans;
        
    }
}
