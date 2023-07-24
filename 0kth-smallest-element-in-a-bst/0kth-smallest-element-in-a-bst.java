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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList();
        dfs(root,nums);
        
        return nums.get(k-1);
    }
    
    private void dfs(TreeNode root, List<Integer> nums){
        if(root == null) return;
        dfs(root.left,nums);
        nums.add(root.val);
        dfs(root.right,nums);        
    }
}