/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode new_head = swap(head);
        if (new_head == null || new_head.next == null) return new_head;
        ListNode node = new_head.next;
        
        while(node !=null){
            node.next = swap(node.next);
            if (node.next == null || node.next.next == null) break;
            node = node.next.next;
        }
        return new_head;
    }
    
    private ListNode swap(ListNode node){
        if (node == null || node.next == null) return node;
        ListNode post = node.next, post_next =node.next.next;
        node.next = post_next;
        post.next = node;
        return post;
    }
}
