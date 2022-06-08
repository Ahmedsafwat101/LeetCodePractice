class Solution {
    public boolean isAnagram(String s, String t) {
        
        if((s == null && t != null) || (t == null && s != null) || (s.length() != t.length())) return false;
        char[]sAsArray = s.toCharArray();
        char[]tAsArray = t.toCharArray();

        Arrays.sort(sAsArray);
        Arrays.sort(tAsArray);
        
        return new String(sAsArray).equals(new String(tAsArray));

    }
}