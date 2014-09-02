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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        traversal(root, list);
        return list;
    }
    
    private void traversal(TreeNode node, List<Integer> list){
        if (node == null) return;
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }
}
