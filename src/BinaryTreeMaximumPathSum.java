/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max_sum;
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        dfs(root);
        return max_sum;
    }
    
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = root.val;
        if (l>0) sum+= l;
        if (r>0) sum+= r;
        max_sum = Math.max(max_sum, sum);
        return Math.max(r,l) > 0? Math.max(r,l)+root.val : root.val;
    }
}
