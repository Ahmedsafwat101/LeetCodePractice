class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length<2) return false;
        HashSet<Integer> uniqSet =  new HashSet();
        for(int i = 0;i<arr.length;i++){
            if(uniqSet.contains(arr[i]*2) || (arr[i]%2 == 0 && uniqSet.contains(arr[i]/2)))  return true;
            uniqSet.add(arr[i]);
        }
        
        return false;
    }
    
}