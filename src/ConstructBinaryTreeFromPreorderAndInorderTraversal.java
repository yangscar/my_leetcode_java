
/**
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return build(preorder, inMap, 0, 0, inorder.length);
    }
    private TreeNode build(int[] pre, Map<Integer, Integer> inMap, 
        int preStart, int inStart, int len){
        if (len == 0) return null;    
        TreeNode root = new TreeNode(pre[preStart]);
        int index = inMap.get(root.val);
        root.left = build(pre, inMap, preStart+1, inStart, index - inStart);
        root.right = build(pre, inMap, preStart+1+index - inStart, index+1,
        len - (index - inStart) - 1);   
        return root;
    }
}
