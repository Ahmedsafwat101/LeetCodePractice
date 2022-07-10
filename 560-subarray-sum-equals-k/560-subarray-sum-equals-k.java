class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null) return 0;
        int currSum = 0;
        int count = 0;
        HashMap<Integer,Integer> frq = new HashMap();
        for(int num: nums){
            
           currSum+= num;
           if(currSum == k)
               count++;
          
            
           count+= frq.getOrDefault(currSum-k,0);
            
           frq.put(currSum,frq.getOrDefault(currSum,0)+1);
        }
        
        return count;
    }
}