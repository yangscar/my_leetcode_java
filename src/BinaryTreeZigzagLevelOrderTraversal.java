/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        trival(rt, root, 0);
        return rt;
    }
    void trival(List<List<Integer>> rt, TreeNode root, int lvl){
        if (root == null) return;
        if (rt.size()< lvl+1) rt.add(new ArrayList(Arrays.asList(root.val)));
        else if (lvl % 2 == 0) rt.get(lvl).add(root.val);
        else rt.get(lvl).add(0, root.val);
        trival(rt, root.left, lvl+1);
        trival(rt, root.right, lvl+1);
    }
}
