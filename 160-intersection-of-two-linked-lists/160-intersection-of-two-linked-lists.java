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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        HashSet<ListNode> seen = new HashSet();
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        int countA = 0, countB = 0;
        
        while(dummyA!=null){
            countA++;
            dummyA = dummyA.next;
        }
        while(dummyB!=null){
            countB++;
            dummyB = dummyB.next;
        }
        
        int diff = Math.abs(countA-countB);
         
        if(countA > countB){
           for(int i = 0;i<diff;i++){
               headA =  headA.next;
           }
        }else{
            for(int i = 0;i<diff;i++){
                headB =  headB.next;
           }  
        }
        
        while(headA!=null && headB!=null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}