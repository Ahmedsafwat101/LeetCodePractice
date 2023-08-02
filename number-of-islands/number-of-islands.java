class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0 ;
        
        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == '1'){
                    numIslands += dfs(grid,i,j,rows,cols);
                }
            }
        }
        return numIslands;
    }
    
    private int dfs(char[][] grid,int rowIndex, int colIndex, int rows, int cols){
        if(rowIndex < 0 || rowIndex > rows-1 ||
           colIndex < 0 || colIndex > cols-1 ||
           grid[rowIndex][colIndex] == '0'
          ) return 0;
        
         // mark visited cell
         grid[rowIndex][colIndex] = '0';
        
        dfs(grid,rowIndex,colIndex+1,rows,cols); // left
        dfs(grid,rowIndex,colIndex-1,rows,cols); // right
        dfs(grid,rowIndex-1,colIndex,rows,cols); // top
        dfs(grid,rowIndex+1,colIndex,rows,cols); // bottom
 
        return 1;
        
    }
}