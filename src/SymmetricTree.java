/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3



 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.left, root.right);
    }
    
    private boolean judge(TreeNode lchild, TreeNode rchild){
        if (lchild == null || rchild == null) {
            if (lchild == null && rchild == null)
                return true;
            else return false;
        }
        
        if (lchild.val != rchild.val) return false;
        
        return judge(lchild.left,rchild.right) &&
            judge(lchild.right,rchild.left);
    }
}
