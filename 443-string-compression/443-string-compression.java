class Solution {
    public int compress(char[] chars) {
        
        if(chars == null || chars.length == 0) return 0;
        if(chars.length == 0) return 1;
        
        StringBuilder sb = new StringBuilder();
        int pt1 = 0, pt2 = 0;
        
       while(pt2<chars.length){
           if(chars[pt1] != chars[pt2]){
                int diff = pt2-pt1;
               sb.append(chars[pt1]);
               if(diff>1)
                   sb.append(diff);
               pt1 = pt2;
             }
             pt2++;
       }   
        
       int diff = pt2-pt1;
       sb.append(chars[pt1]);
       if(diff>1)
         sb.append(diff);
        
       for(int i = 0;i<sb.length();i++){
            chars[i] = sb.charAt(i);
       }
        
        return sb.length();
    }
}