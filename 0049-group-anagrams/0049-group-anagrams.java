class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        Function<String, String> sortWord = (inputWord) -> {
            char[] chars = inputWord.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        };
        
        for (String word : strs) {
            map.computeIfAbsent(sortWord.apply(word)
                                ,k->new ArrayList<>()).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
    
}