class Solution {
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList(); 
        
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == '1')
                    count+=dfs(grid,i,j,rows,cols);
                    
            }
        }
        return count;
    }
    
    
    private int dfs(char[][] grid,int rowIndex, int colIndx,int rows, int cols){
       if(rowIndex > rows-1 ||rowIndex < 0 || colIndx > cols-1 ||colIndx < 0 ||grid[rowIndex][colIndx] == '0') return 0;
        grid[rowIndex][colIndx] = '0';
         
        
        dfs(grid,rowIndex+1,colIndx,rows,cols);
        dfs(grid,rowIndex-1,colIndx,rows,cols);
        dfs(grid,rowIndex,colIndx+1,rows,cols);
        dfs(grid,rowIndex,colIndx-1,rows,cols);

        return 1;
    }
    
  
    
    
    
  
}

