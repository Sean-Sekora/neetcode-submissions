class Solution {
    List<String> result;
    private static Map<Character, char[]> charMap;
    char[] digits;
    public List<String> letterCombinations(String digits) {
        this.result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        this.digits = digits.toCharArray();
        charMap = new HashMap<>();
        charMap.put('0', new char[]{'+'});
        charMap.put('1', new char[0]);
        charMap.put('2', new char[]{'a','b','c'});
        charMap.put('3', new char[]{'d','e','f'});
        charMap.put('4', new char[]{'g','h','i'});
        charMap.put('5', new char[]{'j','k','l'});
        charMap.put('6', new char[]{'m','n','o'});
        charMap.put('7', new char[]{'p','q','r','s'});
        charMap.put('8', new char[]{'t','u','v'});
        charMap.put('9', new char[]{'w','x','y','z'});

        dfs(new StringBuilder(), 0);
        return result;
    }

    private void dfs(StringBuilder current, int i) {
        if (i >= digits.length) {
            result.add(current.toString());
            return;
        }

        for (char c : charMap.get(digits[i])) {
            current.append(c);
            dfs(current, i + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
