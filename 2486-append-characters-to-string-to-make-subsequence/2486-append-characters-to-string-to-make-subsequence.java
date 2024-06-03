class Solution {
    public int appendCharacters(String s, String t) {
        int tIndex = 0;
        int tLength = t.length();
        
        for (int i = 0; i < s.length() && tIndex < tLength; i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {
                tIndex++;
            }
        }
        
        return tLength - tIndex;
    }
}
