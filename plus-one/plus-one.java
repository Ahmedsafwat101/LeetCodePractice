class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int lastIndx = digits.length-1;
        ArrayList<Integer> ans = new ArrayList();
        int carryOn = 1;
        while(lastIndx>= 0){
            int sum =  digits[lastIndx] + carryOn ;
            if(sum  > 9){
                ans.add(0);
                carryOn =  (digits[lastIndx] + carryOn) / 10;
            }else{
               ans.add(sum);
               carryOn = 0;
            }
            
            lastIndx--;
        }
        
        if(carryOn > 0) {
            ans.add(carryOn);
        }
        
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}