class Solution {
    public int coinChange(int[] coins, int amount) {
        if((coins == null || coins.length == 0 )&& amount > 0) return -1;
        if(amount <= 0) return 0;
        int[]memo = new int[amount+1];
        Arrays.fill(memo,Integer.MAX_VALUE);
        return getMinCountRecursively(coins,amount,memo);
    }
    
    private int getMinCountRecursively(int[] coins, int remain, int []memo){
        if(remain < 0) return -1;
        if(remain == 0) return 0;
        if(memo[remain] != Integer.MAX_VALUE) return memo[remain];
        
        int minCount = Integer.MAX_VALUE;
        
        for(int coin: coins){
            int count =  getMinCountRecursively(coins,remain-coin,memo);
            if(count == -1) continue;
            minCount = Math.min(minCount,count+1);
        }
        
        memo[remain] =(minCount == Integer.MAX_VALUE)?-1:minCount;
        
        
        return (minCount == Integer.MAX_VALUE)?-1:minCount;

    }
}