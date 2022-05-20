class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       if(equations == null || equations.size() == 0 || queries == null || queries.size() == 0) return new double[]{};
        //Build Graph
        HashMap<String,List<Node>> graph = buildGraph(equations,values);  
        double[]ans = new double[queries.size()]; 
       
        for(int i = 0;i<queries.size();i++){
            List<String>querie = queries.get(i);
            String start = querie.get(0);
            String target = querie.get(1);
            ans[i] = dfs(start,target,graph,new HashSet());
        }
        
        return ans;
    }
    
    
    private double dfs(String start, String target, HashMap<String,List<Node>> graph, HashSet<String> seen){
        if(!graph.containsKey(start) || !graph.containsKey(target)) return -1.0;
        if(start.equals(target)) return 1.0;
        
        seen.add(start);
        for(Node child:graph.get(start)){
            if(!seen.contains(child.key)){
                double ans = dfs(child.key,target,graph,seen);
                if(ans != -1){
                   return ans = ans*child.val; 
                }
            }
        }
        return -1;  
    }
    
    private HashMap<String,List<Node>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String,List<Node>> graph =  new HashMap();
        for(int i = 0;i<equations.size();i++){
            List<String> equation = equations.get(i);
            String fPart = equation.get(0); //  firstPart 
            String sPart = equation.get(1); //  secondPart 
            double val   = values[i];
            
            graph.putIfAbsent(fPart,new ArrayList());
            graph.putIfAbsent(sPart,new ArrayList());
            
            graph.get(fPart).add(new Node(sPart,val));
            graph.get(sPart).add(new Node(fPart,1/val));
        }
        
        return graph;
    }
        
}

class Node{
    String key;
    double val;
    
    public Node(String key,double val){
        this.key = key;
        this.val = val;
    }
}
