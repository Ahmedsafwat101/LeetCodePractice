class Solution {
    static final int MOD = 1000000007;
    public int knightDialer(int n) {
        if(n == 0) return 0;
        int[][]graph = new int[][]{{4,6},{6,8},{7,9},{8,4},{9,3,0},{},{1,0,7},{6,2},{1,3},{2,4}};
        Integer[][]memo = new Integer[n+1][10];
        int count = 0;
        for(int i = 0;i<=9;i++){
            count = (count+helper(i,n-1,graph,memo))%MOD;
        }
        return count;
    }
    
    
    private int helper(int curr, int N, int [][]graph,Integer [][]memo){
        if(N == 0) return 1;
        if(memo[N][curr]!=null) return memo[N][curr];
        
        int count = 0;
        for(int nei:graph[curr]){
            //System.out.println(curr +","+nei);
            count = (count +helper(nei,N-1,graph,memo))%MOD;
        }
        memo[N][curr] = count;
        return count;
    }
}