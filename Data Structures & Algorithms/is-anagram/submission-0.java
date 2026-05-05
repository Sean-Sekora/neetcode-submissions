class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // Track character count in hashmaps
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        // Populate counts
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sCount.put(sChar, sCount.getOrDefault(sChar, 0) + 1);
            tCount.put(tChar, tCount.getOrDefault(tChar, 0) + 1);
        }


        // Check if counts are equal
        return sCount.equals(tCount);
    }
}
