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
    public boolean isValidBST(TreeNode root) {
        Integer left = null, right = null;
        return traverse(root,left,right);
    }
    
    private boolean traverse(TreeNode root, Integer left, Integer right){
        if(root == null) return true;
        
        if((left!=null && left >= root.val) ||(right!=null && right<=root.val)) return false;
        
        return traverse(root.left,left,root.val) && traverse(root.right,root.val,right);
    }
}