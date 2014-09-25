/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

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
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,
        new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        
        for (ListNode node: lists){
            if (node != null)
                heap.add(node);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        
        while(!heap.isEmpty()){
            ListNode top = heap.poll();
            pre.next = top;
            if (top.next != null)
                heap.add(top.next);
                
            pre = pre.next;
        }
        return dummy.next;
        
    }
}
