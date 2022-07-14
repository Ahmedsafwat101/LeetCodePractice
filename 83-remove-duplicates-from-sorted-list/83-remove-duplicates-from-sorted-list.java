/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummyHead = head;
        ListNode prev = dummyHead;
        
        while(dummyHead!=null){
            
            while(dummyHead.next!=null && dummyHead.val == dummyHead.next.val){
                dummyHead = dummyHead.next;
            }
            
            dummyHead = dummyHead.next;
            prev.next = dummyHead;
            prev = dummyHead;
        }
        
        return head;
    }
}

   