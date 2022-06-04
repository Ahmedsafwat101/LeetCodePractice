class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {    
    if(candidates  == null || candidates.length == 0) return new ArrayList();
      List<List<Integer>> ans = new ArrayList();
      Arrays.sort(candidates);  
      int currSum = 0;  
      int start = 0;  
      helperCombination(start,candidates,ans,target,currSum, new ArrayList());  
      return ans;  
    }
    
    
    private void helperCombination(int start,int[] candidates,List<List<Integer>> ans,int target, int currSum, ArrayList<Integer> subAns){
        if(target == currSum){
            ans.add(new ArrayList(subAns));
        }
        
        for(int i = start;i<candidates.length;i++){
            if(i != start && candidates[i] == candidates[i-1]) continue;
            if(currSum+candidates[i]>target) break;
            
            // else 
            currSum +=candidates[i]; 
            subAns.add(candidates[i]);
            helperCombination(i+1,candidates,ans,target,currSum,subAns);
            currSum-=candidates[i];
            subAns.remove(subAns.size()-1);
        }
    }
}
