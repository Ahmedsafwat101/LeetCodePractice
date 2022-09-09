class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> uniqeChars = new HashSet();
        for(char ch: s.toCharArray()){
            if(uniqeChars.contains(ch)) uniqeChars.remove(ch);
            else uniqeChars.add(ch);
        }
        
        if(uniqeChars.size()<=1) return s.length();
        return s.length()-uniqeChars.size()+1;
    }
}
