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
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.siblings[index] != null) {
                result.append(ch);
                current = current.siblings[index];
                if (current.end) {
                    return result.toString();
                }
            } else {
                break;
            }
        }
        
        return current.end ? result.toString() : "";
    }
}



class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        Trie trie = new Trie();
        String space = " ";
        
        for(String word: dictionary){
            trie.insert(word);
        }
        
        String[] words = sentence.split(" ");
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String newWord = trie.findShortestMatch(word);
            if (newWord.isEmpty()) {
                newWord = word;
            }
            if (i > 0) {
                result.append(space);
            }
            result.append(newWord);
        }
        
        return result.toString();
    }
}