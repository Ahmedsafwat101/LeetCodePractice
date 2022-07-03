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
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode>queue = new LinkedList();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subAns =  new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                subAns.add(curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);

            }
            ans.add(subAns);
        }
        return ans;
    }
}