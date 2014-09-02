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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1=l1, p2 =l2,head,p;
        
        if (p1 ==null) return p2;
        if (p2 ==null) return p1;
        
        if (p1.val <= p2.val) {
            head = new ListNode(p1.val);
            p1 = p1.next;
        }else{
            head = new ListNode(p2.val);
            p2 = p2.next;
        }
        p= head;
        while(true){
            if (p1 ==null) {p.next=p2;return head;}
            if (p2 ==null) {p.next=p1;return head;}
            if (p1.val <= p2.val) {
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p= p.next;
        }
        
  
    }
}
