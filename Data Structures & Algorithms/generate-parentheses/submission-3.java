class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtrack(StringBuilder current, int open, int close, int n) {
        if (open == n && open == close) {
            result.add(current.toString());
            return;
        }
        if (open < n) {
            current.append('(');
            backtrack(current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            backtrack(current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
