class Solution {
    public int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        for(int i = 1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}