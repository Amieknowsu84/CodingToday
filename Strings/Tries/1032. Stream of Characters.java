class StreamChecker {

    StringBuilder inputWord;
    
    TrieNode root;
    
    class TrieNode{
        
        TrieNode children[];
        boolean isLeaf;
        
        TrieNode(){
            children = new TrieNode[26];
            
        }
        
    }
    
  
    void add(String word){
        
        TrieNode it=root;
       
        for(int i = word.length()-1;i >= 0;i--){
            
            int index = word.charAt(i)-'a';
            if(it.children[index] == null)
              it.children[index] = new TrieNode();
            it = it.children[index];
            
        }
        
        it.isLeaf=true;
            
    }
    
    boolean search(StringBuilder word){
        
        TrieNode it=root;
            
        for(int i = word.length()-1;i >= 0;i--){
            
            int index = word.charAt(i)-'a';
            if(it.isLeaf)
                return true;
            if(it.children[index]==null)
                return false;
            it=it.children[index];
            
        }
        
        if(it.isLeaf)
            return true;
        else
            return false;
        
    }
    
    public StreamChecker(String[] words) {
        
        this.inputWord=new StringBuilder();
        this.root=new TrieNode();
        
        for(String word:words){
            add(word);
        }
        
    }
    
    public boolean query(char letter) {
       
        inputWord.append(letter);
        
        return search(inputWord);
    
        
    }
}

