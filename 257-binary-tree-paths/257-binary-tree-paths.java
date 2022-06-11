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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList();
        List<String> paths = new ArrayList();
        traverse(root,paths,"");
        return paths;
    }
    
    private void traverse(TreeNode root,List<String> paths, String path){
        if(root == null) return;
        if(root.left  == null && root.right == null){
           paths.add(path+root.val);
           return;
        }
        
        traverse(root.left,paths,path+root.val+"->");
        traverse(root.right,paths,path+root.val+"->");
        
    }
}