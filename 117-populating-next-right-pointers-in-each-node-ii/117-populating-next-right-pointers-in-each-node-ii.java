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
        
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev  = new Node(); // prev pointer 
            for(int i = 0;i<size;i++){
                Node curr = queue.poll();
                // maintain the prev pointer between diffrient parents on the same level
                if(prev!= null && curr.left!=null){  
                    prev.next = curr.left;
                }else if(prev!= null && curr.right!=null){
                    prev.next = curr.right;
                }
                
              if(curr.left!=null){
                   curr.left.next = curr.right;
                    prev = curr.left;
                    queue.add(curr.left);
               }
               if(curr.right!=null){
                    prev = curr.right;
                    queue.add(curr.right);
               }
            } 
        }
        return root;
    }
}