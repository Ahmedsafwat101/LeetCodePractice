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
        while(headA!=null){
            seen.add(headA);
            headA = headA.next;
        }
        
        while(headB!=null){
            if(seen.contains(headB)) return headB;
            headB = headB.next;
        }
        
        return null;
    }
}