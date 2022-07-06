class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[mid+1])
                right = mid;
            else 
                left = mid+1;
        }
        
        return right;
    }
}

/*              l
              m r   
  ex: 1 2 3 4 5 6 -> 5  index > index+1
      r
  ex: 6 5 4 3 2 1 -> 0  index > index+1
             l r
  ex: 1 2 3 4 6 5 -> 4  index > index+1
  
*/