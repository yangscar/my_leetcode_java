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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        traversal(root, 0, ans);
        return ans;
    }
    
    private void traversal(TreeNode node, int level, ArrayList<ArrayList<Integer>> ans){
        if (node == null) return;
        if (level >= ans.size()) ans.add(new ArrayList<Integer>());
        ans.get(level).add(node.val);
        traversal(node.left,level+1,ans);
        traversal(node.right,level+1,ans);
    }
}
