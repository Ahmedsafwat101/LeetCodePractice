class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Assume the given arrays are valid and have values
        List<Integer> ans =  new ArrayList();
        for(int i = 0;i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    ans.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}