class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null  ||  nums.length == 0) return new ArrayList();
        
        List<List<Integer>> ans = new ArrayList();
        
        permutationHelper(nums,ans,new HashSet(), new ArrayList());
        
        return ans;
    }
    
    
    
    private void permutationHelper(int[] nums,List<List<Integer>> ans,HashSet<Integer> seen,ArrayList<Integer>subAns){
        if(subAns.size() == nums.length){ // termination 
            ans.add(new ArrayList(subAns));
        }
        
        
        for(int i = 0;i<nums.length;i++){
            if(!seen.contains(nums[i])){
                
                seen.add(nums[i]);
                subAns.add(nums[i]);
                permutationHelper(nums,ans,seen,subAns);
                
                seen.remove(nums[i]);
                subAns.remove(subAns.size()-1);
            
            }
        }
    }
    
    
}