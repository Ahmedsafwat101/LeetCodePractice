class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return new String();
        Stack<Integer>count = new Stack();
        Stack<String>words = new Stack();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        while(index<s.length()){
            
            if(Character.isDigit(s.charAt(index))){
                int val = 0;
                while(index<s.length() && Character.isDigit(s.charAt(index))){
                    val = val*10+(s.charAt(index++)-'0'); 
                }
                count.push(val);
            }
            else if(s.charAt(index) == '['){
                words.push(ans.toString());
                ans = new StringBuilder();
                index++;
                
            }else if(s.charAt(index) == ']'){
                
                StringBuilder temp = new StringBuilder(words.pop()); // get the prev String
                int val  = count.pop();
                
                for(int i = 0;i<val;i++){
                    temp.append(ans.toString());
                }
                
                ans = new StringBuilder();
                ans.append(temp.toString());
                index++;
            }else{
                ans.append(s.charAt(index++));
            }
        }
        return ans.toString();
    }
}