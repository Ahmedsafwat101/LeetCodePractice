class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length<2) return false;
        Arrays.sort(arr);
        
        for(int i = 0;i<arr.length;i++){
            int secdIndx = i;
            int firstIndx = search(arr,arr[i]*2);
            if(firstIndx != -1 && firstIndx != secdIndx) return true;
        }
        
        return false;
    }
    
    private int search(int[]arr,int target){
        int left = 0;
        int right = arr.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid] ==  target) return mid;
            if(arr[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
    
}