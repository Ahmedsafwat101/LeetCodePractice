class Solution {
    public int trap(int[] height) {
        // we can calculate a traped water for 2 blocks we need to have to peak points and one lower point in between
        if(height == null || height.length < 3) return 0;
        
        int[]maxLeftArr = new int[height.length];
        int[]maxRightArr = new int[height.length];
        int maxLeft = height[0], maxRight = height[height.length-1], ans = 0;
        
        for(int i = 1;i<height.length;i++){
            maxLeft = Math.max(maxLeft,height[i]); 
            maxLeftArr[i] = maxLeft;
        }
        
        for(int i = height.length-2;i>=0;i--){
            maxRight = Math.max(maxRight,height[i]); 
            maxRightArr[i] = maxRight;
        }
        
        
        for(int i = 1;i< height.length-1;i++){
             ans+= Math.min(maxLeftArr[i],maxRightArr[i])-height[i];
        }
        return ans;
    }
    
}