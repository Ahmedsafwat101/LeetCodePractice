class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        HashSet<Integer> uniqueNumbers = new HashSet();
        for(int i = 0; i< nums.length;i++){
            if(uniqueNumbers.contains(nums[i])){
                return true;
            }
            uniqueNumbers.add(nums[i]);
        }
        return false;
    }
}