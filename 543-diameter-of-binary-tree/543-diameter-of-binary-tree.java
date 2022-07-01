/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
    
        int diameter = getHeight(root.left) +  getHeight(root.right); 
        
       int leftSubtreeDiameter =  diameterOfBinaryTree(root.left);
       int rightSubtreeDiameter =  diameterOfBinaryTree(root.right);
        
       return Math.max(diameter,Math.max(leftSubtreeDiameter,rightSubtreeDiameter));

    }
    
    
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        
        int lhs=getHeight(root.left);
        int rhs=getHeight(root.right);
        
        return Math.max(lhs,rhs)+1;
    }
}