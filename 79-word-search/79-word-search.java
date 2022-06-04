class Solution {
    public boolean exist(char[][] board, String word) {
       if(board == null || board.length == 0 || word == null || word.length() == 0) return false;
       int cols = board[0].length; 
       int rows = board.length;   
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                 if(board[i][j] == word.charAt(0) &&  dfs(board,i,j,word,0)) return true;
            }
        }
        return false;
    }
    
    
    private boolean dfs(char[][] board, int rIdx, int cIdx, String word,int pathLength){
        if(word.length() == pathLength) return true;
        if(rIdx>board.length-1 || rIdx<0 || cIdx>board[0].length-1 || cIdx < 0  || board[rIdx][cIdx] == '#' || board[rIdx][cIdx] != word.charAt(pathLength)) return false;
        
        board[rIdx][cIdx] = '#';
        
        if(dfs(board,rIdx+1,cIdx,word,pathLength+1)||
        dfs(board,rIdx,cIdx+1,word,pathLength+1)||
        dfs(board,rIdx-1,cIdx,word,pathLength+1)||
        dfs(board,rIdx,cIdx-1,word,pathLength+1)) return true;
        
        board[rIdx][cIdx] = word.charAt(pathLength);
        
        return false;
    }
}