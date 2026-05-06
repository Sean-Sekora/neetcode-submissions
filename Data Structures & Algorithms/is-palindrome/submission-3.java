class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNum(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNum(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNum(char c) {
        return (c <= 'Z' && c >= 'A') ||
                (c <= 'z' && c >= 'a') ||
                (c <= '9' && c >= '0');
    }
}
