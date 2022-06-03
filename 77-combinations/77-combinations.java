class Solution {
    public List<List<Integer>> combine(int n, int k) {
      if(k==0) return new ArrayList();
     
      List<List<Integer>> ans = new ArrayList();
      backtarcking(1,ans,new ArrayList(),n,k);
      return ans;
    }
    
    private void backtarcking(int start,List<List<Integer>> ans,List<Integer> tempAns, int n, int k){
        if(tempAns.size()==k){
            ans.add(new ArrayList(tempAns));
            return;
        }
        for(int i = start;i<=n;i++){
            tempAns.add(i);
            backtarcking(i+1,ans,tempAns,n,k);
            tempAns.remove(tempAns.size()-1);

        }
    }   
}

