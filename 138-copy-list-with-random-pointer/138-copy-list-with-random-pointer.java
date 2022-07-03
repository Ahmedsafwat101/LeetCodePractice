/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        HashMap<Node,Node> copyMap = new HashMap();
        Node dummyHead = head;
        while(dummyHead!=null){
            copyMap.put(dummyHead,new Node(dummyHead.val));
            dummyHead = dummyHead.next;
        }
        dummyHead = head;
        while(dummyHead!=null){
            copyMap.get(dummyHead).next = copyMap.get(dummyHead.next);
            copyMap.get(dummyHead).random = copyMap.getOrDefault(dummyHead.random,null);
            dummyHead = dummyHead.next;
        }
        
        return copyMap.get(head);
    }
}