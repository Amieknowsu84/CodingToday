class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.remove();

                if (current.equals(endWord))
                    return level;
                
                char[] currentChar = current.toCharArray();
                
                for(int j = 0; j < current.length(); j++){
                    char atIndex = currentChar[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        currentChar[j] = c;
                        String newWord = new String(currentChar);
                        if(!visited.contains(newWord) && words.contains(newWord)){
                            visited.add(newWord);
                            queue.add(newWord);
                        }
                    }
                    currentChar[j] = atIndex;
                }

            }
            level++;
        }

        return 0;
    }
}
