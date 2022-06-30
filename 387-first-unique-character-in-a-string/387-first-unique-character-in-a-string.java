class Solution {
    public int firstUniqChar(String s) {
        if(s.isEmpty()) return 0;
        int[]charFreq = new int[26];
        for(char ch: s.toCharArray()){
            charFreq[ch-'a']++;
        }
        
        for(int i = 0;i<s.length();i++){
            if(charFreq[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }
}