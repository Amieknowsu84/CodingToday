class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = Arrays.stream(strs)
            .collect(Collectors.groupingBy(str -> {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }));
        
        return new ArrayList<>(map.values());
    }
    
}