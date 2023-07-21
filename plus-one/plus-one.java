class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int lastIndx = digits.length-1;
        ArrayList<Integer> ans = new ArrayList();
        int carryOn = 1;
        while(lastIndx>= 0){
            int sum =  digits[lastIndx] + carryOn ;
            // System.out.println("sum:" + sum);
            if(sum  > 9){
                ans.add(0);
                // digits[lastIndx]  = 0;
                carryOn =  (digits[lastIndx] + carryOn) / 10;
                // System.out.println("carryOn:" + carryOn);

            }else{
               ans.add(sum);
               carryOn = 0;
               // digits[lastIndx] = sum;
                // break;
            }
            
            lastIndx--;
        }
        
        if(carryOn > 0) {
            ans.add(carryOn);
        }
        
        // System.out.println(ans);
        Collections.reverse(ans);
        // System.out.println(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}