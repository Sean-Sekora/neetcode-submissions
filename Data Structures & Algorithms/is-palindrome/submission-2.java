class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (l == r) {
                left++;
                right--;
                continue;
            } else if (isAlpha(l) && isAlpha(r)) {
                return false;
            }
            if (!isAlpha(l)) {
                left++;
            }
            if (!isAlpha(r)) {
                right--;
            }
        }

        return true;
    }

    private boolean isAlpha(char c) {
        return (c <= 'z' && c >= 'a') || (c <= '9' && c >= '0');
    }
}
