class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int longest = 0;
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            } else {
                seen.add(s.charAt(right));
                longest = Math.max(longest, right-left+1);
                right++;
            }
        }

        return longest;
    }
}
