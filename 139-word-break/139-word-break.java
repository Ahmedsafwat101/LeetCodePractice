class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> seenWords = new HashSet(wordDict);
        boolean[]dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                if(dp[j] && seenWords.contains(s.substring(j,i))){
                    dp[i] = true; // mark the start of the new word as true
                }
            }
        }
        return dp[s.length()];
    }
}

