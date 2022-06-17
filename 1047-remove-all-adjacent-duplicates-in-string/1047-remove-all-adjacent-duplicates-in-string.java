class Solution {
    public String removeDuplicates(String s) {
        if(s == null ||s.length() == 0) return new String();
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(stack.isEmpty() || stack.peek() != ch){
                 stack.push(ch);
            }else{
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}