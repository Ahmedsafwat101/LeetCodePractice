class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int maxDiff = 0;
        int minSoFar = Integer.MAX_VALUE;
        
        for(int i = 0;i<prices.length;i++){
            if(minSoFar>prices[i])
               minSoFar = prices[i];
            else{
               maxDiff = Math.max(maxDiff,prices[i]-minSoFar);
            }
        }
        
        return maxDiff;
    }
}