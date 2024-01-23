class Solution {
    int max;

    public int maxLength(List<String> arr) {
        max = 0;
        solve(arr, 0, new HashSet<>());
        return max;
    }

    void solve(List<String> arr, int index, Set<Character> charSet) {
     
        for (int i = index; i < arr.size(); i++) {
            String str = arr.get(i);
            if (canAddString(str, charSet)) {
                max = Math.max(max, charSet.size());
                solve(arr, i + 1, charSet);
                removeStringFromSet(str, charSet);
            }
        }
    }

    boolean canAddString(String str, Set<Character> charSet) {
        Set<Character> charSetPrev = new HashSet<>(charSet);
        //System.out.println(str);
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.clear();
                charSet.addAll(charSetPrev);
                return false;
            }else{
                charSet.add(c);
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
