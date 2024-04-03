class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(board,word,0,i,j)){
                        return true;
                    }    
                }
            }
        }
        return false;
    }
    
    boolean solve(char[][] board, String word,int index,int i,int j){
        if(index==word.length()){
           return true;
        }
        
        if(i<0||i>=board.length||j<0||j>=board[0].length){
            return false;
        }
        
        
        boolean result = false;
        
        if(word.charAt(index) == board[i][j]){
            char current = board[i][j];
            board[i][j] = '.';
            result = solve(board,word,index+1,i-1,j) || solve(board,word,index+1,i,j-1)
                    ||solve(board,word,index+1,i,j+1) || solve(board,word,index+1,i+1,j);
            board[i][j] = current;
        }
        
        
        return result;
    
    }
}