class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;
        
        int pt1 = 0 , pt2 = 0;
        
        while(pt2 < nums.length){
            if(nums[pt1]!=nums[pt2]){
                pt1++;
                nums[pt1] = nums[pt2];
            }
            pt2++;
        } 
    return pt1+1;
    }
}