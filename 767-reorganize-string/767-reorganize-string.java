class Solution {
    public String reorganizeString(String s) {
       if(s == null || s.length() == 0) return ""; 
       HashMap<Character,Integer>freq =  new HashMap();
       StringBuilder ans = new StringBuilder();
       for(char ch:s.toCharArray()){
           freq.put(ch,freq.getOrDefault(ch,0)+1);
       }
       //MaxHeap sort based on value of the key 
       PriorityQueue<Character> pq = new PriorityQueue((obj1,obj2)->freq.get(obj2)-freq.get(obj1));
       pq.addAll(freq.keySet());
       
       int maxFreq = freq.get(pq.peek());
       if(maxFreq > Math.ceil(s.length()/2.0)) return ""; 
        
       System.out.println(pq); 
      System.out.println(freq); 

       while(pq.size()>1){
           
       
           char currChar = pq.remove();
           char nextChar = pq.remove();

           int  currFreq = freq.get(currChar);
           int nextFreq = freq.get(nextChar);

           ans.append(currChar);
           ans.append(nextChar);

           freq.put(currChar,currFreq-1); 
           freq.put(nextChar,nextFreq-1); 

           if(currFreq-1 > 0){
             pq.add(currChar);
           }
           
           if(nextFreq-1 > 0){
             pq.add(nextChar);
           }
       }
        
        if(!pq.isEmpty()){
             char currChar = pq.remove();
             int  currFreq = freq.get(currChar);
             if(currFreq>1) return ""; // two same char concectives
             ans.append(currChar);
            
        } 
        
       return ans.toString(); 
    }
}