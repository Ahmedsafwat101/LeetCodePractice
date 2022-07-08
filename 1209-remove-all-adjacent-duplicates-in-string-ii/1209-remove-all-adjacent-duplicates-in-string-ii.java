class Solution {
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length()==0) return "";
        Stack<Freq>myStack = new Stack();
        for(int i=0;i<s.length();i++){
            
            if(myStack.isEmpty()){
               Freq freq = new Freq(s.charAt(i),1);  
               myStack.push(freq);

            }
            else{
                Freq top = myStack.peek();
                if(top.ch == s.charAt(i)){
                        top.freq++;
                        myStack.push(top);
                        if(top.freq == k){
                          int counter = k;
                          while(counter>0 && myStack.size()>0){
                            myStack.pop();
                            counter--;
                          }    
                       }
                }else{
                        Freq freq = new Freq(s.charAt(i),1);  
                        myStack.push(freq);     

                    }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while(!myStack.isEmpty()){
            ans.append(myStack.pop().ch);
        }
     
        return ans.reverse().toString();
    }
    
}

class Freq{
    char ch;
    int freq;
    public Freq(char ch, int freq){
        this.ch =  ch;
        this.freq = freq; 
    }
}

    
    
    


