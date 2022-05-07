class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
 HashMap<Integer,Integer> hashMap1 =  new HashMap();
       List<Integer>intersection =  new ArrayList();
          
       for(int num: nums1){
          hashMap1.put(num,hashMap1.getOrDefault(num,0)+1);
       }
          
       for(int num:nums2){
           if(hashMap1.containsKey(num) && hashMap1.get(num)>0){
               intersection.add(num);
               hashMap1.put(num,hashMap1.get(num)-1);
           }
       }   
       return intersection.stream().mapToInt(i->i).toArray();   
    }
}