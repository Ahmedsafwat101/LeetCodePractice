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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode dummyNode = new ListNode(0,head); 
        ListNode prev = dummyNode;
        
        while(head!=null){
            
            if(head.val == val){
                prev.next = head.next;
            }else{
                prev = head;

            }
            head = head.next;    
        }
        
       return dummyNode.next;
    }
}