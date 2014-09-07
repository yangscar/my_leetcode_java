/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        ArrayList<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        for (int i=2; i<= rowIndex+1; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j=0; j< i-2; j++){
                row.add(lastRow.get(j)+lastRow.get(j+1));
            }
            row.add(1);
            lastRow = row;
            
        }
        return lastRow;  
    }
}
