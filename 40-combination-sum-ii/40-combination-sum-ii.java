class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(candidates);

        backtarcking(ans,new ArrayList<Integer>(),candidates,target,0);
        return ans;
    }


  
private void backtarcking(List<List<Integer>> ans,List<Integer>tempAns,int[] candidates, int target, int start){
        if(target==0){
            ans.add(new ArrayList(tempAns));
            return;
        }
      
        for(int i = start;i<candidates.length;i++){
            if(i!=start && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            tempAns.add(candidates[i]);
            backtarcking(ans,tempAns,candidates,target-candidates[i],i+1);
            tempAns.remove(tempAns.size()-1);
        }
    }
}