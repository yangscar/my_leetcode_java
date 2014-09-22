/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        findSum(rt, queue, root, 0, sum);
        return rt;
    }
    void findSum(List<List<Integer>> rt, ArrayDeque queue, TreeNode root, int sum, int target){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if(sum + root.val == target){
                queue.offerLast(root.val);
                rt.add(new ArrayList<Integer>(queue));
                queue.removeLast();
            }
            return;
        }
        
        queue.offerLast(root.val);
        findSum(rt, queue, root.left, sum+root.val, target);
        findSum(rt, queue, root.right, sum+root.val, target);
        queue.removeLast();
    }
}
