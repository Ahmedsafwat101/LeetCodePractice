class Solution {
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        while(left<=right){
            long mid = left+(right-left)/2;
            if(sum(mid) == n) return (int) mid;
            else if(sum(mid)>n)
                right = mid-1;
            else{
                
                left =mid+1;
            }
        }
        
        return (int) left-1;
    }
    

    private long sum(long n){
        long ans = (n*(n+1))/2;
        return ans;
    } 
}


