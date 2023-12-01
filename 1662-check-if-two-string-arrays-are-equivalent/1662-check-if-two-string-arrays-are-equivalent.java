class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String str : word1) {
            sb1.append(str);
        }

        // Concatenate strings in word2
        StringBuilder sb2 = new StringBuilder();
        for (String str : word2) {
            sb2.append(str);
        }

        // Compare the concatenated strings
        return sb1.toString().equals(sb2.toString());
        
    }
}