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
        for(String word: words){
            String newWord = trie.findShortestMatch(word);
            if(newWord.equals("")){
               newWord = word;
            }
            boolean isFirstWord = result.length() == 0;
            newWord = isFirstWord ? newWord : space+newWord;
            result.append(newWord);
        }
        
        return result.toString();
    }
}