class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        backtrack("", 0, 0, n);

        return result;
    }

    private void backtrack(String current, int open, int close, int n) {
        if (open == n && open == close) {
            result.add(current);
            return;
        }
        if (open < n) {
            backtrack(current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(current + ")", open, close + 1, n);
        }
    }
}
