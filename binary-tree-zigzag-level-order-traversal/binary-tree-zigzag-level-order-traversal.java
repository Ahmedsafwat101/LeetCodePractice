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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        List<List<Integer>> result = new ArrayList();
        List<Integer> rootVal = new ArrayList();
        rootVal.add(root.val);
        result.add(rootVal);
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            
          int size = queue.size();
          List<Integer> subAns = new ArrayList();  
          for(int i = 0;i<size;i++){
              
              TreeNode curr = queue.poll(); 
            
              if(curr.left != null){
                subAns.add(curr.left.val);
                queue.add(curr.left);
              }
              if(curr.right != null){
                subAns.add(curr.right.val);
                 queue.add(curr.right);  
              }
              
          }
            
          level++;
            
          if(level%2!=0){ // odd then reverse
              Collections.reverse(subAns);
          }
          if(subAns.size()>0){
           result.add(subAns); 
          }
          
        }
        
        return result;
        
    }
}