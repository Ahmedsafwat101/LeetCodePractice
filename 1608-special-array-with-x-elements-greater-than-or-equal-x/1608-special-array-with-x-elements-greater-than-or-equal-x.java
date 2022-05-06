class Solution {
    public int specialArray(int[] nums) {
        
		Arrays.sort(nums);
        int start=0;
        int end=nums.length;
        
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            int curr=count(nums,mid);
            if(curr==mid) return mid;
            if(curr<mid) end=mid-1;
            else start=mid+1;
        }
        
        return -1;
    }
    public static int count(int[]arr,int t)
    {
        int c=0;
        for(int i:arr)
        {
            if(i>=t)
            {
                c++;
            }
        }
        return c;
    }
}