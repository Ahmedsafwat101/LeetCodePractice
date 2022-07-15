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
        if(head == null) return head;
       
         int len = 0;
         ListNode dummyhead = head;
        
         while(dummyhead!=null){
            dummyhead = dummyhead.next;
            len++;
         }
        
         int index = len-n;
         System.out.println(index);
         ListNode newHead = new ListNode(0,head);
         dummyhead = newHead;
         while(index>0){
            System.out.println(dummyhead.val);
            dummyhead = dummyhead.next;
             index--;
             
         }
         dummyhead.next = dummyhead.next.next;

         return newHead.next;
    }
}