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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        getHeight(root);   
        return diameter;
    }
       
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        
        int lhs=getHeight(root.left);
        int rhs=getHeight(root.right);
        
        diameter = Math.max(diameter,lhs+rhs);
        
        return Math.max(lhs,rhs)+1;
    }
    
}