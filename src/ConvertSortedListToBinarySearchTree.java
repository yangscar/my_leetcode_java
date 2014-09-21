/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, listLength(head));
    }
    
    private TreeNode sortedListToBST(ListNode head, int len){
        if (len == 0) return null;
        if (len == 1) return new TreeNode(head.val);
        TreeNode root = new TreeNode(nthNode(head, len/2).val);
        root.left = sortedListToBST(head, len/2 );
        root.right = sortedListToBST(nthNode(head, len/2+1),len -len/2-1);
        return root;
    }
    
    private int listLength(ListNode head){
        int n =0;
        while (head != null){
            ++n;
            head = head.next;
        }
        return n;
    }
    
    private ListNode nthNode(ListNode head, int n){
        while(n-->0){
            head = head.next;
        }
        return head;
    }
}
