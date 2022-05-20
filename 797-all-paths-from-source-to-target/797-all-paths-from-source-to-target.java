class Solution {
    final static int START = 0;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     if(graph==null || graph.length==0) return null;
      HashMap<Integer,List<Integer>>graphMap = new HashMap();
    
        for(int i = 0;i<graph.length;i++){
            List<Integer>list = new ArrayList();
            for(int j = 0;j<graph[i].length;j++){
                list.add(graph[i][j]);
            }
            graphMap.put(i,list);
        }
        int target = graph.length-1;
        List<List<Integer>> paths =  new ArrayList();
        dfs(START,target,graphMap,paths, new ArrayList());
        return paths;   
    }
    
    private void dfs(int start , int target, HashMap<Integer,List<Integer>> graph,List<List<Integer>> paths,List<Integer> path){
        if(path.size()==0) path.add(Solution.START);
        if(start == target){
            paths.add(new ArrayList(path));
        }
        
        for(int child:graph.get(start)){
            path.add(child);
            dfs(child,target,graph,paths,path);
            path.remove(path.size()-1);
        }
        
    }
}