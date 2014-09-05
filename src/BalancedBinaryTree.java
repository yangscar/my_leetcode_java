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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >=0;
    }
    
    private int getHeight(TreeNode root){
        if (root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if ( l>=0 & r >=0 )
            if (Math.abs(l-r)<2)
                return Math.max(l,r)+1;
        return -1; // not balance at this node.
    }
}
