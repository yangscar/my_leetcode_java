/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]



*/


public class Solution {
    public ArrayList<ArrayList<Integer> > generate(int numRows) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return ans;
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        ans.add(lastRow);
        for (int i=2; i<= numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j=0; j< i-2; j++){
                row.add(lastRow.get(j)+lastRow.get(j+1));
            }
            row.add(1);
            lastRow = row;
            ans.add(lastRow);
        }
        return ans;  
    }
}
