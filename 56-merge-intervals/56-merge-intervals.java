class Solution {
    public int[][] merge(int[][] intervals) {
        //sort using start time
        if(intervals == null || intervals.length < 2) return intervals;
        List<int[]>mergedIntervals = new ArrayList();
        Arrays.sort(intervals,(arr1,arr2)-> Integer.compare(arr1[0],arr2[0]));
        for(int[] currInterval: intervals){
            
             if(mergedIntervals.size() == 0){ 
                 mergedIntervals.add(currInterval);
             }
             else{
                 int lastIndex = mergedIntervals.size()-1;
                 int[] prevInteval = mergedIntervals.get(lastIndex);
                 if(prevInteval[1]>=currInterval[0]){
                     mergedIntervals.get(lastIndex)[0] = Math.min(prevInteval[0],currInterval[0]);
                     mergedIntervals.get(lastIndex)[1] = Math.max(prevInteval[1],currInterval[1]);
                 }else{
                     
                    mergedIntervals.add(currInterval);
                 }
             }    
        }
       return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
 }
}