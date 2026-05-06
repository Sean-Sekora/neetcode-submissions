class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int have = 0;
        int need = countT.size();
        int[] match = {-1, -1};
        int matchLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < matchLen) {
                    matchLen = right - left + 1;
                    match[0] = left;
                    match[1] = right;
                }

                char l = s.charAt(left);
                window.put(l, window.get(l) - 1);

                if (countT.containsKey(l) && window.get(l) < countT.get(l)) {
                    have--;
                }

                left++;
            }
        }

        return matchLen == Integer.MAX_VALUE ? "" : s.substring(match[0], match[1] + 1);
    }
}
