class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || bottoms == null || tops.length == 0 || bottoms.length == 0 || bottoms.length != tops.length ) return -1;
        int maxFreqValue = Integer.MIN_VALUE;
        int maxFreqKey = Integer.MIN_VALUE;
        HashMap<Integer,Integer>freq = new HashMap();
        HashMap<Integer,Integer>topFreq = new HashMap();
        HashMap<Integer,Integer>bottomFreq = new HashMap();

        for(int i = 0;i<tops.length;i++){
            topFreq.put(tops[i],topFreq.getOrDefault(tops[i],0)+1);
            bottomFreq.put(bottoms[i],bottomFreq.getOrDefault(bottoms[i],0)+1);
            
            freq.put(tops[i],freq.getOrDefault(tops[i],0)+1);
            if(tops[i] == bottoms[i]) continue;
            freq.put(bottoms[i],freq.getOrDefault(bottoms[i],0)+1);
        }
        
        // Sort or getMinimum
        for(int key:freq.keySet()){
            if(maxFreqValue<freq.get(key)){
                maxFreqValue = freq.get(key);
                maxFreqKey = key;
            }
        }
       
        if(maxFreqValue < tops.length) return -1;
        
        int diff2 =  maxFreqValue-topFreq.get(maxFreqKey);
        int diff1 =  maxFreqValue-bottomFreq.get(maxFreqKey);

        // getting num of rotations
        return Math.min(diff1,diff2);
    }
}


