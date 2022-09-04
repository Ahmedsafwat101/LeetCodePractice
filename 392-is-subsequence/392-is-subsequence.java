class Solution {
    public boolean isSubsequence(String s, String t) {
        if((s.length()==0 && t.length()==0) ||(s.length() == 0 && t.length()!=0)) return true;
        if((t.length() == 0 && s.length()!=0)) return false;
        int i=0; //part
        int j=0; // full word
        while(j<t.length()){
            char chT=  t.charAt(j++);
            char chS=  s.charAt(i);
            if(chT==chS)
                i++;
            if(i==s.length()) return true;
        }
        if(i<s.length()) return false;
        return true;
    }
}