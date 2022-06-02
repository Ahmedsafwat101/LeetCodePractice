class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        List<List<Integer>> ans =  new ArrayList();
        HashMap<Integer,Integer> freq =  new HashMap();
        
        for(int num: nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        
        permutaionHelper(freq,ans,new ArrayList(),nums.length);
        
        return ans;
    }
    
    private void permutaionHelper(HashMap<Integer,Integer> freq, List<List<Integer>> ans, ArrayList<Integer> subAns, int size){
        if(subAns.size() == size){
            ans.add(new ArrayList(subAns));
        }
        
        
        for(int key: freq.keySet()){
            int val = freq.get(key);
            if(val == 0) continue;
            
            freq.put(key,val-1);
            subAns.add(key);
            permutaionHelper(freq,ans,subAns,size);
            freq.put(key,val);
            subAns.remove(subAns.size()-1);
        }
    }
}