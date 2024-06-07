class TrieNode{
        char ch;
        TrieNode siblings[];
        boolean end;
        TrieNode(char ch){
            this.ch = ch;
            this.siblings = new TrieNode[26];
        }
}

class Trie{
    TrieNode root;
    
    Trie(){
      root = new TrieNode('.');    
    }
    
    void insert(String word){
        TrieNode current = root;
        for(Character ch: word.toCharArray()){
            int index = ch-'a'; 
            if(current.siblings[index] == null){
                current.siblings[index] = new TrieNode(ch);
            }
            current = current.siblings[index];
        }
        current.end = true;
    }
    
    String findShortestMatch(String word){
        StringBuilder result = new StringBuilder();
        
        if(word == null || word.equals("")){
            return result.toString();
        }
        
        TrieNode current = root;
        
        for(Character ch: word.toCharArray()){
            int index = ch-'a';
            if(current.siblings[index]!=null){
                result.append(ch);
                if(current.siblings[index].end){
                    return result.toString();
                }
                current = current.siblings[index];
            }else{
                return current.end ? result.toString(): "";
            }
        }
        
        if(current.end){
            result.append(current.ch);
            return result.toString();
        }else{
            return "";
        }
    }
}



class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        Trie trie = new Trie();
        
        for(String word: dictionary){
            trie.insert(word);
        }
        
        
        String[] words = sentence.split(" ");
        for(String word: words){
            String newWord = trie.findShortestMatch(word);
            //System.out.println(" -- "+newWord);
            if(newWord.equals("")){
               newWord = word;
            }
            newWord = result.length() == 0 ? newWord : " "+newWord;
            result.append(newWord);
        }
        
        return result.toString();
    }
}