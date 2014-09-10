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
      List<Integer> res = new ArrayList<Integer>();
      TreeNode curr, prev;
      Stack<TreeNode> S = new Stack<TreeNode>();
      curr = root;
      do {
          while (curr != null ){ /* go left down */
              S.push(curr);
              curr = curr.left;
          }
          prev = null;
          while (!S.empty()){
              curr = S.pop();
              if (curr.right == prev) {
                  res.add(curr.val);
                  prev = curr;
              } else {
                  S.push(curr);
                  curr = curr.right;
                  break;
              }
          }
      } while(!S.empty());
      
      return res;
    }
}
