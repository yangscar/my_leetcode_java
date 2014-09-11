/**

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return generateTrees(1,0);
        return generateTrees(1,n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        //Use List to store the subTrees
        List<TreeNode> subTree = new ArrayList<TreeNode>(); 
        if (start > end) {
            subTree.add(null);
            return subTree;
        }
        
        for (int k=start; k <= end; k++)
            for (TreeNode leftSub:generateTrees(start, k-1))
                for (TreeNode rightSub:generateTrees(k+1,end)){ 
                    TreeNode node = new TreeNode(k);
                    node.left = leftSub;
                    node.right = rightSub;
                    subTree.add(node);
                }
        return subTree;
    }
}
