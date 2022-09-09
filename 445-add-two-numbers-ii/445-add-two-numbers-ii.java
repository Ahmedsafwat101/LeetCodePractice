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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode l1Rev = reverseList(l1);
        ListNode l2Rev = reverseList(l2);
        
        ListNode resRev = new ListNode();
        ListNode dummy = resRev;
        addTwoNumbersHelper(l1Rev,l2Rev,dummy);
        return reverseList(resRev.next);
    }
    
    private void addTwoNumbersHelper( ListNode l1,  ListNode l2,  ListNode dummy){
        int carryOn = 0;
        while(l1!=null || l2!=null){
            
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            
            int sum = (val1+val2+carryOn)%10; // 9+9+3 = 21%10 = 21/10 =2.1
            carryOn = (val1+val2+carryOn)/10;
            
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            
            l1 = l1!=null?l1.next: null;
            l2 = l2!=null?l2.next: null;
        }
        
        if(carryOn>0){
             dummy.next = new ListNode(carryOn);
            dummy = dummy.next;
        }
    }
  
  
    
     private ListNode reverseList(ListNode head) {
        if(head == null) return head;
        
        ListNode next = null;
        ListNode prev = null;
        
        while(head !=null){
             next = head.next;
             head.next = prev;
             prev = head;
             head = next;
        }
        
        return prev;

    }
}





