class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int pt1= 0,pt2 = 0;
        while(pt2< nums.length){
            if(nums[pt2]!=0){
                
                nums[pt1] = nums[pt2];
                if(pt1 != pt2) 
                    nums[pt2] = 0;
                pt1++;
            }
            pt2++;
        }
        
        return;
    }
}