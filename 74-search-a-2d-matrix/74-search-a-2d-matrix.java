class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        for(int[]row : matrix){
            if(search(row,target) != -1 ) return true;
        }
        return false;
    }
    
    
    private int search(int[]arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]== target) return mid;
            if(arr[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}