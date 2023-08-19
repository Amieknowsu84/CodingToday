class Trie {
    
    Node parent;

    class Node{
        
       char character;
       Node child[];
       boolean end;
        
       Node(char character){
           this.character=character;
           this.child=new Node[26];
       } 
    }
    
    public Trie() {
        parent=new Node('.');
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
    }
    
    public boolean search(String word) {
        
        Node current=parent;
        
         for(char character: word.toCharArray()){
            int index = character-'a';
            if(current.child[index] == null){
               return false;
            }
            current=current.child[index];
        }
        
        return current.end;
    }
    
    public boolean startsWith(String prefix) {
        Node current=parent;
        
         for(char character: prefix.toCharArray()){
            int index = character-'a';
            if(current.child[index] == null){
               return false;
            }
            current=current.child[index];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */