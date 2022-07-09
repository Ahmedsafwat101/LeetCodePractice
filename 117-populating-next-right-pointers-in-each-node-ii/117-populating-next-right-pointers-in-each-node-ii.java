/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
         
        Node startLevel = new Node();
        Node iterator = startLevel;
        Node dummyRoot = root;
       
        while(dummyRoot!=null){
            
            if(dummyRoot.left!=null){
                iterator.next = dummyRoot.left;
                iterator = dummyRoot.left;
            }
            
            if(dummyRoot.right!=null){
                 iterator.next = dummyRoot.right;
                 iterator = dummyRoot.right;
            }
            
            dummyRoot = dummyRoot.next; // multiple node in the same level 
            
            // Maintain the new level 
            if(dummyRoot==null){
                dummyRoot = startLevel.next;
                iterator = startLevel;
                startLevel.next = null;
            }
            
        }
        
       return root;  
    }
}