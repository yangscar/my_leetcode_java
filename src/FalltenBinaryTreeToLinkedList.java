/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        addNodes(queue,root);
        TreeNode pre = queue.removeFirst();
        TreeNode cur = new TreeNode(-1);
        while(!queue.isEmpty()){
            cur = queue.removeFirst();
            pre.left = null;
            pre.right = cur;
            pre = cur;
        }
        cur.left = null; cur.right = null;
    }
    
    private void addNodes(ArrayDeque<TreeNode> queue, TreeNode root){
        if (root == null) return;
        queue.offerLast(root);
        addNodes(queue, root.left);
        addNodes(queue, root.right);
    }
}
