class Solution {
    
    Set<Character>openBrackets = new HashSet(Arrays.asList('(', '[','{'));
    Set<Character>closeBrackets = new HashSet(Arrays.asList(')',']','}'));

    public boolean isValid(String s) {    
       // assume the empty string is nit valid and any string with length smaller than 2 isn't valid
       if(s == null || s.length()<2) return false;   
       Stack<Character> stack = new Stack();
      
       for(int i = 0;i<s.length();i++){
           char currChar = s.charAt(i);
          
           if(openBrackets.contains(currChar)){  // Open
               stack.push(currChar);
           }else if(closeBrackets.contains(currChar)){  // Close
               if(stack.isEmpty()) return false;
               char lastSeenBracket = stack.pop();
               if( (lastSeenBracket == '(' && currChar != ')') ||
                   (lastSeenBracket == '{' && currChar != '}')||
                   (lastSeenBracket == '[' && currChar != ']')) 
                   return false;
           }
       }
       return stack.isEmpty()?true:false; 
    }
}