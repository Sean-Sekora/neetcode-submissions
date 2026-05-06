class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null) return 0;
        int longest = 0;

        int left = 0;
        int right = 0;
        int maxF = 0;
        Map<Character, Integer> freq = new HashMap<>();

        while (right < s.length()) {
            char r = s.charAt(right);
            freq.put(s.charAt(right), freq.getOrDefault(r, 0) + 1);
            maxF = Math.max(maxF, freq.get(r));

            while (right - left + 1 - maxF > k) {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}
