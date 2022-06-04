class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        int start = 0;
        subSetHelper(start,nums,ans,new ArrayList());
        return ans;
    }
    
    private void subSetHelper(int start, int[]nums,List<List<Integer>> ans,ArrayList<Integer>subAns){
         ans.add(new ArrayList(subAns));
        for(int i = start;i<nums.length;i++){
            subAns.add(nums[i]);
            subSetHelper(i+1,nums,ans,subAns);
            subAns.remove(subAns.size()-1);
        }
    }
}