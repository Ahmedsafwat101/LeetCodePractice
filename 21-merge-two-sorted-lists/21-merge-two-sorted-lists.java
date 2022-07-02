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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode head = new ListNode();
        ListNode dummyHead = head;

        while(list1!=null && list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;

            if(val1 > val2){
                dummyHead.next = list2;
                list2 = list2.next;
            }else{
                dummyHead.next = list1;
                list1 = list1.next;
            }
            dummyHead = dummyHead.next;
        }
        
        if(list1!=null){
            dummyHead.next = list1;
        }
        
         if(list2!=null){
            dummyHead.next = list2;
        }
        
        return head.next;
    }
}