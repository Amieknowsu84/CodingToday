class Solution {
    Node parent;
    List<String> result;
    char[][] board;

    class Node{
       char character;
       Node child[];
       boolean end;
       String word; 
        
       Node(char character){
           this.character=character;
           this.child=new Node[26];
       } 
    }
    
    public void insert(String word) {
        Node current=parent;
        
        for(char character: word.toCharArray()){
            int index = character-'a';
            if(current.child[index] == null){
                current.child[index] = new Node(character);
            }
            current=current.child[index];
        }
        
        current.end=true;
        current.word=word;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        parent=new Node('.');
        for(String word:words){
            insert(word);
        }
        result=new ArrayList<>();
        this.board=board;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int index=board[i][j]-'a';
                if(parent.child[index] != null){
                    solve(i,j,parent);
                }
            }
        }
        
        return result;
    }
    

    void solve(int i,int j,Node current){
        
        if(current!=null && current.end){
            result.add(current.word);
            current.end=false;
        }
        
        if(i<0||j<0||j>=board[0].length||i>=board.length||board[i][j]=='$'){
            return;
        }
        
        int index=board[i][j]-'a';
        if(current.child[index] == null){
            return;
        }
        
        char character=board[i][j];
        board[i][j]='$';
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            solve(newRow, newCol, current.child[index]);
        }
        board[i][j]=character;
            
    }
    
}