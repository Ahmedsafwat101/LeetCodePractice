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
        if(root == null) return true;
        Integer left = null;
        Integer right = null;
        return isValidBSTHelper(root,left,right);
    }
    
    private boolean isValidBSTHelper(TreeNode root, Integer left, Integer right){
        if(root == null) return true;
        
        if(left != null && left >= root.val ||  right != null && right <= root.val ) return false;
    return isValidBSTHelper(root.left,left,root.val) && isValidBSTHelper(root.right,root.val,right);
    }
}