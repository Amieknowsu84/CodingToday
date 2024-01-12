class Solution {

    public boolean halvesAreAlike(String s) {
        int cnt = 0;
        int mid = s.length() / 2;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i >= mid) {
                cnt += isVowel(c) ? 1 : 0;
            } else {
                cnt -= isVowel(c) ? 1 : 0;
            }
        }

        return cnt == 0;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
