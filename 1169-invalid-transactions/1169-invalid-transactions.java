class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        if(transactions==null || transactions.length == 0) return new ArrayList();
        int numOftransactions = transactions.length; // 2
        String[][] transactionsArray =  new String[numOftransactions][5];
        List<String>inValid = new ArrayList();
        boolean[] added = new boolean[numOftransactions];
        
        for(int i=0;i<numOftransactions;i++){
            String[] transaction = transactions[i].split(",");
            
             int amount = Integer.parseInt( transaction[2]);
             if(amount>1000 && !added[i]){
               inValid.add(transactions[i]);
               added[i]= true;
            }
            for(int j=i+1;j<numOftransactions;j++){
               String[] transaction2 = transactions[j].split(",");
                int time1 =  Integer.parseInt(transaction[1]);
                int time2 =  Integer.parseInt(transaction2[1]);    
               if(transaction2[0].compareTo(transaction[0])==0 && Math.abs(time1-time2)<=60 &&   
                  transaction2[3].compareTo(transaction[3])!=0) {
                   if(!added[j]){
                      inValid.add(transactions[j]);     
                       added[j]= true;
                   }
                   
                   if(!added[i]){
                      inValid.add(transactions[i]); 
                      added[i]= true;
                   }       
               }   
            }
        }
       
         return inValid;          
    }                 
}

/*transactions
[4];
alice 20 800 mtv     invalid
alice 50 100 beijing invalid*/

