class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0;
        
        for (int i = 0; i < s.length(); i++) {
            xor ^= s.charAt(i);
            xor ^= t.charAt(i);
        }
        
        xor ^= t.charAt(t.length() - 1);
        
        return (char) xor;
    }
}