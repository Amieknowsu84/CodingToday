class Solution {
    int max;

    public int maxLength(List<String> arr) {
        max = 0;
        solve(arr, 0, 0, new HashSet<>());
        return max;
    }

    void solve(List<String> arr, int index, int currentLength, Set<Character> charSet) {
        max = Math.max(max, currentLength);

        for (int i = index; i < arr.size(); i++) {
            String str = arr.get(i);
            if (!hasDuplicates(str) && canAddString(str, charSet)) {
                addStringToSet(str, charSet);
                solve(arr, i + 1, currentLength + str.length(), charSet);
                removeStringFromSet(str, charSet);
            }
        }
    }

    boolean canAddString(String str, Set<Character> charSet) {

        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                return false;
            }
        }
        return true;
    }

    void addStringToSet(String str, Set<Character> charSet) {
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }
    }

    void removeStringFromSet(String str, Set<Character> charSet) {
        for (char c : str.toCharArray()) {
            charSet.remove(c);
        }
    }
    
    boolean hasDuplicates(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return true;
            }
        }
        return false;
    }
}
