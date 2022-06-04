class Solution {
    public int uniquePathsIII(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int rIdx = -1 , cIdx = -1;
        int zeros = 0;
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 1){
                    rIdx = i;
                    cIdx = j;
                }else if(grid[i][j]==0){
                   zeros++;
                }
            }
        }
        
       return dfs(grid,rIdx,cIdx,zeros);
    }
    
    
    private int dfs(int[][] grid,int rIdx, int cIdx,int zeros){
       if(rIdx < 0 || rIdx > grid.length-1 || cIdx < 0 || cIdx > grid[0].length-1 ||grid[rIdx][cIdx] == -1) return 0;
       if(grid[rIdx][cIdx] == 2){ 
           if(zeros == -1) return 1;
           return 0;
        }
       grid[rIdx][cIdx] = -1; 
        
       int sum =  dfs(grid,rIdx+1,cIdx,zeros-1)
        +dfs(grid,rIdx-1,cIdx,zeros-1)
        +dfs(grid,rIdx,cIdx+1,zeros-1)
        +dfs(grid,rIdx,cIdx-1,zeros-1);
       grid[rIdx][cIdx] = 0;   
        
       return sum;
    }
}