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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head; // null
        int len = 0;
        int steps = 0; // steps from the begining 
        ListNode pt1 = head;
        ListNode dummyhead = new ListNode(0,head); // dummyhead.next = head;
        while(pt1!=null){
            pt1 = pt1.next;
            len++;
        }
        
        steps = len-n;
        pt1 = dummyhead;
        
        if(steps < 0) return null; // steps greater than list len
        
        while(steps>0){
            pt1 = pt1.next;
            steps--;
        }
        
        pt1.next = pt1.next.next;
        
        return dummyhead.next;
        
    }
}