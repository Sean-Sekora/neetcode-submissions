class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] c1 = new char[26];
        char[] c2 = new char[26];

        for (int i = 0; i < s1.length(); i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (Arrays.equals(c1, c2)) return true;
            c2[s2.charAt(right) - 'a']++;
            c2[s2.charAt(left) - 'a']--;
            left++;
        }

        return Arrays.equals(c1, c2);
    }
}
