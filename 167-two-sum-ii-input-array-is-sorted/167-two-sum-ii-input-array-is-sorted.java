class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = -1;
        int index2 = -1;
        if(numbers == null || numbers.length<2) return new int[]{index1,index2};
        
        for(int i = 0;i<numbers.length;i++){
            int diff = target-numbers[i];
            int searchIndex = search(numbers,diff);
            if(searchIndex!=-1 && searchIndex != i ){
                index1 = Math.min(searchIndex+1,i+1);
                index2 = Math.max(searchIndex+1,i+1);
                return new int[]{index1,index2};
            }
                
        }
        return new int[]{index1,index2};
    }
    
    
    
    private int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] ==  target) return mid;
            if(nums[mid] >target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}