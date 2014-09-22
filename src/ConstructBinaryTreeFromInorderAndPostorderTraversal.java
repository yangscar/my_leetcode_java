/**
Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i)
            inMap.put(inorder[i],i);
        return build(inMap, postorder, 0, postorder.length-1, postorder.length);
    }
    
    private TreeNode build(Map<Integer, Integer> inMap, int[] postorder, int inBegin, int postLast, int len){
        if (len == 0) return null;
        TreeNode root = new TreeNode(postorder[postLast]);
        int iRoot = inMap.get(root.val);
        root.left = build(inMap, postorder, inBegin, postLast-(len-(iRoot-inBegin)) ,iRoot-inBegin);
        root.right = build(inMap, postorder, iRoot+1, postLast-1, len -(iRoot-inBegin)-1);
        return root;
    }
}
