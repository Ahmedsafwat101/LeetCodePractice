class Solution {
    public int minSteps(String s, String t) {
        int[]freqMap = new int[26];
        int count = 0;
        for(int i = 0;i<s.length();i++){
            freqMap[s.charAt(i)-'a']++;
            freqMap[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++){
            count+= freqMap[i]>0?freqMap[i]:0;
        }
        
        return count;
    }
}



    

