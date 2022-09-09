/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
         
        // Edge Case 
        if(isBadVersion(1)) return 1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid) && mid-1>0 && !isBadVersion(mid-1) ) return mid;
            if(isBadVersion(mid) && mid-1>0 && isBadVersion(mid-1)) right = mid-1;
            else  left = mid+1;
            
        }
        return left;
    }
}
