class Trie {
    
    private final Node parent;
    
    private static final int ALPHABET_SIZE = 26;

    static class Node{
       char character;
       Node child[];
       boolean end;
       String word;
        
       Node(char character){
           this.character = character;
           this.child = new Node[ALPHABET_SIZE];
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
            current = current.child[index];
        }
        
        current.end = true;
        current.word = word;
    }
    
    private Node searchPrefix(String prefix) {
        Node current = parent;
        
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.child[index] == null) {
                return null;
            }
            current = current.child[index];
        }
        
        return current;
    }
    
    public boolean search(String word) {
        Node current = searchPrefix(word);
        
        return current!=null && current.end;
    }
    
    public boolean startsWith(String prefix) {
       return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */