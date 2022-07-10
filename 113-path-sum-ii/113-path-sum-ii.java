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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList();
        List<List<Integer>> paths = new ArrayList();
        traverse(root, targetSum,0,paths, new ArrayList<Integer>());
        return paths;
    }
    
    private void traverse(TreeNode root, int targetSum, int currSum, List<List<Integer>> paths, List<Integer>path){
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null &&  (currSum+root.val) == targetSum){
            paths.add(new ArrayList(path));
        }
                
        traverse(root.left,targetSum,currSum+root.val,paths,path);
        traverse(root.right,targetSum,currSum+root.val,paths,path); 
        
        path.remove(path.size()-1);
    
    }
}