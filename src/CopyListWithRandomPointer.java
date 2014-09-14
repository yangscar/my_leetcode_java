/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // from 1 -> 2 create 1 -> 1 -> 2 -> 2
        for (RandomListNode cur = head; cur != null;){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        for (RandomListNode cur = head; cur != null;){
            if (cur.random != null)
                cur.next.random = cur.random.next; //.next is the new list
            cur = cur.next.next;
        }
        // Split them
        RandomListNode dummy = new RandomListNode(-1);
        for(RandomListNode cur = head, new_cur = dummy; cur != null;){
            new_cur.next = cur.next;
            new_cur = new_cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
