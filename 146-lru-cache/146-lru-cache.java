class DoubleLinkedListNode{
     DoubleLinkedListNode next;
     DoubleLinkedListNode prev;
     int val;
     int key;
    public DoubleLinkedListNode(){
        
    }
    public DoubleLinkedListNode(int val, int key){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    HashMap<Integer,DoubleLinkedListNode>meme;
    int capacity;
    DoubleLinkedListNode head;
    DoubleLinkedListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        meme = new HashMap();
        this.head = new DoubleLinkedListNode();
        this.tail = new DoubleLinkedListNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(meme.containsKey(key)){
           DoubleLinkedListNode currNode  = meme.get(key);
           delete(currNode);
           addToHead(currNode); 
           return currNode.val;
        }
        
        //else
        return -1;
    }
    
    public void put(int key, int value) {
        if(meme.containsKey(key)){
           DoubleLinkedListNode currNode  = meme.get(key);
           delete(currNode);
           currNode.val = value;
           addToHead(currNode); 
        }else{
            
            if(meme.size() >= this.capacity){
                //evect 
                 meme.remove(this.tail.prev.key);
                 delete(this.tail.prev);
            }
            
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(value,key);
            meme.put(key,newNode);
            addToHead(newNode); 
        }
    }
    
    public void delete(DoubleLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addToHead(DoubleLinkedListNode node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */