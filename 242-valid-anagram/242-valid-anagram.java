class Solution {
    public boolean isAnagram(String s, String t) {
        if((s == null && t != null) || (t == null && s != null) || (s.length() != t.length())) return false;
        
        HashMap<Character,Integer> freq = new HashMap();
        for(char ch: s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            
        }
        
        for(char ch: t.toCharArray()){
            if(!freq.containsKey(ch) || freq.get(ch) <= 0 ) return false;
            freq.put(ch,freq.get(ch)-1); 
        }
        
        return true;
    }
}