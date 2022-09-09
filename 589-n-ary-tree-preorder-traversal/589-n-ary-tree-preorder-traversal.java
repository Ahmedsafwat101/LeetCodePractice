/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans = new ArrayList();
    public List<Integer> preorder(Node root) {
        if(root == null) return ans;
        helper(root);
        return ans;
    }
    
    private void helper(Node root){
        if(root == null) return;
         ans.add(root.val);
        for(Node curr: root.children){
            
            helper(curr);
        }
    }
}