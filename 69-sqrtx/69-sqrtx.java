class Solution {
    public int mySqrt(int x) {
        if(x <=1) return x;
        
        long left = 0;
        long right = x;
        while(left<right){
            long mid = left+(right-left)/2;
            long mulResult = mid*mid;
            if(mulResult == x) return (int) mid;
            if(mulResult>x)
                right = mid;
            else    
                left = mid+1;
        }
        return (left*left!=x)?(int)left-1:(int)left;
    }
}