class Solution {
    public int findKthPositive(int[] arr, int k) {
      
        int count = 0;
        int indx = 0;
        for(int  i = 1;i<=arr[arr.length-1];i++){
            if(arr[indx] != i){
                count++;
            }else{
                indx++;
            }
            
            if(count == k) return i;
        }
        
        return arr[arr.length-1]+(k-count);
    }
}