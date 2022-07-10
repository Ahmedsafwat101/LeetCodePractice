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
    int count = 0;
    int k;
    HashMap<Integer,Integer> freq  = new HashMap();
    

    public int pathSum(TreeNode root, int targetSum) {
        this.k = targetSum;
        preorder(root, 0);
        return count;
        
    }
    
    private void preorder(TreeNode node,int currentSum){
        if(node == null) return;
        currentSum += node.val;
        
        if (currentSum == k)
            count++;
        
        count += freq.getOrDefault(currentSum-k,0);
        freq.put(currentSum,freq.getOrDefault(currentSum,0)+1);


        preorder(node.left, currentSum);
        preorder(node.right, currentSum);
        
        freq.put(currentSum,freq.get(currentSum)-1);
        
        
    }
}