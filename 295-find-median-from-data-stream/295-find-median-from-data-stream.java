class MedianFinder {
    PriorityQueue<Integer> q1;     // max
    PriorityQueue<Integer> q2;   // min

    public MedianFinder() {
        q1 = new PriorityQueue(Collections.reverseOrder());
        q2 = new PriorityQueue();

    }
    
    public void addNum(int num) {
        if(q1.isEmpty()||q1.peek()>num)
            q1.add(num);
        else
           q2.add(num);
            
        if(q1.size()>q2.size()+1){
            q2.add(q1.peek());
            q1.poll();
        }else if(q2.size()>q1.size()+1){
                q1.add(q2.peek());
                q2.poll();

        }
    }
    
    public double findMedian() {
        
        // System.out.println(lo);
        //         System.out.println(high);
        if(q1.size() > q2.size()) return q1.peek();
        if(q1.size() < q2.size()) return q2.peek();
        return  ((double) q1.peek() + q2.peek()) * 0.5;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */