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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
         List<List<Integer>>  ans = new ArrayList();
         Queue<TreeNode> queue = new LinkedList();
         queue.offer(root);
        
        while(!queue.isEmpty()){
            int childrenSize = queue.size();
            List<Integer> subAns = new ArrayList();
            for(int i = 0 ;i < childrenSize;i++){
                   TreeNode currNode = queue.poll();
                   subAns.add(currNode.val);   
                if(currNode.left!=null){
                  queue.offer(currNode.left);               
                }

                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
                
            }
            ans.add(subAns);
        }
        
        return ans;
        
    }
}