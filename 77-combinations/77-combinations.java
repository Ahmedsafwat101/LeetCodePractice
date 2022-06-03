class Solution {
    public List<List<Integer>> combine(int n, int k) {
      if(k==0) return new ArrayList();
      int []nums = new int[n];
      for(int i = 0;i<nums.length;i++){
          nums[i] = i+1;
      }  
      List<List<Integer>> ans = new ArrayList();
      backtarcking(0,ans,new ArrayList(),nums,k);
      return ans;
    }
    
    private void backtarcking(int start,List<List<Integer>> ans,List<Integer> tempAns, int []nums, int k){
        if(tempAns.size()==k){
            ans.add(new ArrayList(tempAns));
            return;
        }
        for(int i = start;i<nums.length;i++){
            tempAns.add(nums[i]);
            backtarcking(i+1,ans,tempAns,nums,k);
            tempAns.remove(tempAns.size()-1);

        }
    }   
}

