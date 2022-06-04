class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        
        helperCombination(1,k,n,0,ans, new ArrayList());
        
        return ans;
    }

    
    private void helperCombination(int start,int k, int target,int currSum,List<List<Integer>> ans , ArrayList<Integer> subAns){
        if(target == currSum && subAns.size() == k){
             ans.add(new ArrayList(subAns));
        }
        for(int i = start;i<=9;i++){
            if(currSum+i>target) break;
            // else 
            currSum += i ; 
            subAns.add(i);
            helperCombination(i+1,k,target,currSum,ans,subAns);
            currSum-= i ;
            subAns.remove(subAns.size()-1);
        }
    }
}
