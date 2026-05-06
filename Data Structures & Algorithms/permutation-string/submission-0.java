class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        char[] c1 = new char[26];
        char[] c2 = new char[26];

        for (char c : s1.toCharArray()) {
            c1[c-'a']++;
        }

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char l = s2.charAt(left);
            char r = s2.charAt(right);
            c2[r-'a']++;
            while (right - left + 1 > s1.length()) {
                c2[l-'a']--;
                left++;
            }
            if (Arrays.equals(c1, c2)) return true;
            right++;
        }

        return c1 == c2;
    }
}
