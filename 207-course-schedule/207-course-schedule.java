class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Check valid input
        Map<Integer,HashSet<Integer>> graph = new HashMap();
        HashSet<Integer>seen = new HashSet();
        for(int[]prerequisite: prerequisites){
            
            int fPrerequisite = prerequisite[0];
            int sPrerequisite = prerequisite[1];
            
            graph.putIfAbsent(sPrerequisite, new HashSet());
            graph.get(sPrerequisite).add(fPrerequisite);
        }
        
        for(int i = 0;i<numCourses;i++){
            if(isCyclic(graph,seen,i)) return false;
        }
        return true;
    }
    
    private boolean isCyclic(Map<Integer,HashSet<Integer>> graph, HashSet<Integer>seen, int node){
        if(seen.contains(node)) return true;
        if(!graph.containsKey(node)) return false;
        seen.add(node);
        
        for(int nei:graph.get(node))
            if(isCyclic(graph,seen,nei)) return true;
        
        seen.remove(node);
        graph.get(node).clear();

        return false;
    }
}
