import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.remove();

                if (currentWord.equals(endWord))
                    return level;

                // Generate all possible next words from the current word
                List<String> nextWords = generateNextWords(currentWord);

                // Check each next word and add to the queue if it's valid and not visited
                for (String nextWord : nextWords) {
                    if (!visited.contains(nextWord) && wordSet.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.add(nextWord);
                    }
                }
            }
            level++;
        }

        return 0; // If no ladder exists
    }

    // Method to generate all possible next words by changing one character at a time
    private List<String> generateNextWords(String word) {
        List<String> nextWords = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originalChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    charArray[i] = c;
                    nextWords.add(new String(charArray));
                }
            }
            charArray[i] = originalChar; // Restore the original character
        }
        return nextWords;
    }
}
