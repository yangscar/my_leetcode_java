/**
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> S = new ArrayDeque<TreeNode>();
        ArrayList<TreeNode> Q = new ArrayList<TreeNode>();
        inOrderTraversal(S, Q, root);
        int i = 0, j = Q.size()-1;
        while(i < Q.size()-1 && Q.get(i).val <=Q.get(i+1).val) ++i;
       
        while(j > 0 && Q.get(j-1).val <= Q.get(j).val) --j;

        int tmp = Q.get(j).val;
        Q.get(j).val = Q.get(i).val;
        Q.get(i).val = tmp;
    }
    
    private void inOrderTraversal(ArrayDeque<TreeNode> S, ArrayList<TreeNode> Q, TreeNode root){
        while(true){
            if (root != null){
                S.offerLast(root);
                root = root.left;
            } else if (!S.isEmpty()){
                root = S.removeLast();
                Q.add(root);
                root = root.right;
            } else
                break;
        }
    }
}
