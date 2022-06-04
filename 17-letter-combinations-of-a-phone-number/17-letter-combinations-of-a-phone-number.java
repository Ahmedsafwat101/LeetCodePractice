class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList();
        String[] numbers= new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        for(char digit: digits.toCharArray()){
            queue.offer(digit-'0');
        }
        ans.add("");
        while(!queue.isEmpty()){
            int index = queue.poll();
            String keypad = numbers[index];
            
            List<String> subAns = new ArrayList();
            
            for(int i = 0;i<ans.size();i++){
              for(char ch:keypad.toCharArray()){
                  StringBuilder  sb = new StringBuilder(); 
                  sb.append(ans.get(i));
                  sb.append(ch);
                  subAns.add(sb.toString());   
              }
            }
            ans = subAns; 
        }
        return ans;
    }
}