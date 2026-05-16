class Solution {
    List<List<String>> result;
    String s;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        this.s = s;
        dfs(0, new ArrayList<>());
        return result;
    }

    private void dfs(int i, List<String> partition) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                partition.add(s.substring(i, j + 1));
                dfs(j + 1, partition);
                partition.removeLast();
            }
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
