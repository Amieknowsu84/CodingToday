class WordDictionary {
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


    public WordDictionary() {
         parent=new Node('#');
    }
    
    public void addWord(String word) {
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
        return search(0,word,parent);
    }
        
    boolean search(int index,String word,Node current){
        
        if(index == word.length()){
            if(current!=null && current.end){
              return true;
            }else{
              return false;
            }
        }
        
        if(word.charAt(index) != '.'){
           int nodeIndex = word.charAt(index)-'a';
           if(current.child[nodeIndex] != null){
              return search(index+1,word,current.child[nodeIndex]);
           } 
        }else{
            for(int i=0;i<current.child.length;i++){
                if(current.child[i] != null){
                    if(search(index+1,word,current.child[i]))
                        return true;
                }
            }
        }    
        
        return false;
        
    }    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */