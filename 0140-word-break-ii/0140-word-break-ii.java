class Solution {
    
    List<String> result;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);
        generateSentence(s, words, 0, new StringBuilder(), 0);
        return result;
    }
    
    void generateSentence(String s, Set<String> wordDict, int index, StringBuilder sb, int wordCount) {
        if (index >= s.length()) {
            if (sb.length() == s.length() + wordCount - 1) {
                result.add(sb.toString());
            }
            return;
        }
        
        int originalLength = sb.length();
        
        for (int i = index; i < s.length(); i++) {
            String word = s.substring(index, i + 1);
            if (wordDict.contains(word)) {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(word);
                generateSentence(s, wordDict, i + 1, sb, wordCount + 1);
                sb.setLength(originalLength); // backtracking
            }
        }
    }
}
