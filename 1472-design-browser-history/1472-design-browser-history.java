class Node{
    private String url;
    private Node next;
    
    public Node(String url){
       this.url = url;
   }
    
   public Node(String url, Node next){
       this.url = url;
       this.next = next;
   }
    
   String getUrl(){ return this.url;}  
   Node getNext(){ return this.next;}
    
   void setUrl(String url){ this.url = url;}  
   void setNext(Node next){ this.next = next;}
    
}

class BrowserHistory {
    private Node node;
    private HashMap<Integer,Node> lookUp;
    Integer  counter;
    Integer localCounter;
    public BrowserHistory(String homepage) {
        counter = 0; localCounter = 0;
        node = new Node(homepage);
        lookUp = new HashMap();
        lookUp.put(counter,node);
        counter++;
       
    }
    
    public void visit(String url) {
        if(localCounter<counter){
            counter = localCounter+1;
        }
        
        Node curr = new Node(url);
        node.setNext(curr);
        node = node.getNext();
        lookUp.put(counter,node);
        counter++;
        localCounter++;          
    }
    
    public String back(int steps) {
        int backSteps = Math.max(localCounter-steps,0);
        localCounter = backSteps;
        node = lookUp.get(backSteps);
        return node.getUrl();
    }
    
    public String forward(int steps) {
        int forwardSteps = Math.min(localCounter+steps,counter-1);
        localCounter = forwardSteps;
        node = lookUp.get(forwardSteps);
        return node.getUrl();
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */