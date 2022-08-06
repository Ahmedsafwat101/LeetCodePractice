/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
     private ListNode hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return fast;
        }
        
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head; // null empty
        
        ListNode pt1 = head;
        ListNode pt2 = hasCycle(head);
        if(pt2 == null) return pt2; // no cycle
        
        while(pt1!=pt2){
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        
        return pt1;

    }
}