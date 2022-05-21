class Solution {
    final static  String START = "JFK";
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null || tickets.size() == 0) return new ArrayList();
        
        //Build Graph
        HashMap<String,PriorityQueue<String>> graph = buildGraph(tickets);
        LinkedList<String> path= new LinkedList<>();//result 
        dfs(START,graph,path);        
        return path;
    }
    
    private void dfs(String start,HashMap<String,PriorityQueue<String>> graph,LinkedList<String> path){
        PriorityQueue<String> childreen = graph.get(start);
        while(childreen!=null && !childreen.isEmpty()){
            String child =  childreen.remove();
            dfs(child,graph,path);
        }
        path.addFirst(start);

    }
    
    private HashMap<String,PriorityQueue<String>>buildGraph(List<List<String>> tickets){
        HashMap<String,PriorityQueue<String>> graph =  new HashMap();
        for(List<String>ticket:tickets){
            String departure = ticket.get(0);
            String arrival = ticket.get(1);
            graph.putIfAbsent(departure, new PriorityQueue<String>());
            graph.get(departure).add(arrival);
        }
        return graph;
    }
       
}