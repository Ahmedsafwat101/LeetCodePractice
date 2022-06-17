/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node dummyHead = head;
        while(dummyHead != null){
            
            if(dummyHead.child!=null){
                Node endNode = dummyHead.child;
                Node startNode = dummyHead.child;
                while(endNode.next!=null){
                    endNode = endNode.next;
                }
                if(dummyHead.next != null){
                  endNode.next = dummyHead.next;
                  dummyHead.next.prev = endNode;
                }
                
                dummyHead.next = startNode;
                startNode.prev = dummyHead;
                
                dummyHead.child = null;
            }
            dummyHead = dummyHead.next;
        }
        
        return head;
    }
}