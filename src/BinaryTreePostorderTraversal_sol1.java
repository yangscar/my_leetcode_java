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
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<Integer>();
       traversal(root, ans);
       return ans;
    }
    private void traversal(TreeNode node, List<Integer> ans){
        if (node == null) return;
        traversal(node.left, ans);
        traversal(node.right, ans);
        visit(node, ans);
        
    }
    private void visit(TreeNode node, List<Integer> ans){
        ans.add(node.val);
    }
}
