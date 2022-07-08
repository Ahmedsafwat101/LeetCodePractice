class Solution {
    ArrayList<Integer>ans = new ArrayList();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer,HashSet<Integer>> graph = buildGraph(numCourses,prerequisites);
        
        HashSet<Integer>cycle = new HashSet();
        HashSet<Integer>visisted = new HashSet();
        
        
        for(int i = 0;i<numCourses;i++){
            if(isCyclic(graph,cycle,visisted,i)) return new int[0];
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
    private boolean isCyclic(Map<Integer,HashSet<Integer>> graph, HashSet<Integer>cycle, HashSet<Integer>visisted, int node){
        if(cycle.contains(node)) return true;
        if(visisted.contains(node)){ 
            return false;
        }
        
        cycle.add(node);
        
        for(int nei:graph.get(node))
            if(isCyclic(graph,cycle,visisted,nei)) return true; 
        
        cycle.remove(node);
        visisted.add(node);
        ans.add(node);

        return false;
    }
    
    private Map<Integer,HashSet<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        Map<Integer,HashSet<Integer>> graph = new HashMap();
         for(int i = 0;i<numCourses;i++)
            graph.put(i, new HashSet());


        for(int[]prerequisite: prerequisites){
            
            int fPrerequisite = prerequisite[0];
            int sPrerequisite = prerequisite[1];
            
            graph.get(fPrerequisite).add(sPrerequisite);
        }
        return graph;
    }
}
