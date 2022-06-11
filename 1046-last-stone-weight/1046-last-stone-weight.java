class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        
        for(int s:stones){
            pq.add(s);
        }
        
        while(pq.size()>1){
            int stone1 = pq.remove();
            int stone2 = pq.remove();
            
            if(stone1!=stone2){
                pq.add(stone1-stone2);
            }
        }
        
        return pq.isEmpty()?0:pq.peek();
    }
}