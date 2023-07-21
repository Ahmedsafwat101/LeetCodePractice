class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k == 0 || (k % nums.length) == 0) return;
        k = (k % nums.length);
        
        reverse(nums.length-k,nums.length-1,nums);
        reverse(0,nums.length-k-1,nums);
        reverse(0,nums.length-1,nums);


    }
    
    private void reverse(int start, int end, int[]nums){
        while(start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}