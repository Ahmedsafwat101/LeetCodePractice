class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Check valid input
        
        Map<Integer,HashSet<Integer>>graph = new HashMap();
        HashSet<Integer>seen = new HashSet();
        for(int[] prerequisite:prerequisites){
            graph.putIfAbsent(prerequisite[0],new HashSet());
            graph.get(prerequisite[0]).add(prerequisite[1]);
            
        }
        
        for(int i = 0;i<numCourses;i++){
            if(dfs(i,graph,seen)==false) return false;
        }
        return true;
    }
    
    private boolean dfs(int num,Map<Integer,HashSet<Integer>>graph,HashSet<Integer>seen){
        if(seen.contains(num)) return false;
        if(graph.get(num)==null||graph.get(num).size()==0) return true;
        seen.add(num);
        for(int nei:graph.get(num)){
            if(dfs(nei,graph,seen)==false) return false;
            
        }
        seen.remove(num);
        graph.get(num).clear();
        return true;        
    }
}