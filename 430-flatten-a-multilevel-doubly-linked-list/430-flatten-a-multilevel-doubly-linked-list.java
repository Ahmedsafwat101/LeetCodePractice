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
                // point to the end node in the branch level
                Node endNode = dummyHead.child; 
                // point to the start node in the branch level
                Node startNode = dummyHead.child;
                while(endNode.next!=null){
                    endNode = endNode.next;
                }
                //check if the node has a next node pointing to it
                if(dummyHead.next != null){   
                    // maintain the the endNode pointers 
                  endNode.next = dummyHead.next;
                  dummyHead.next.prev = endNode;
                }
                  // maintain the the startNode pointers 
                dummyHead.next = startNode;
                startNode.prev = dummyHead;
                
                 // remove childNode
                dummyHead.child = null;
            }
            
            dummyHead = dummyHead.next;
        }
        
        return head;
    }
}