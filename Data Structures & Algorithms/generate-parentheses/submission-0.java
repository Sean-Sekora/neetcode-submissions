class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        backtrack("", 0, 0, n);

        return result;
    }

    private void backtrack(String curent, int open, int close, int n) {
        if (open == n && open == close) {
            result.add(curent);
            return;
        }
        if (open < n) {
            backtrack(curent + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(curent + ")", open, close + 1, n);
        }
    }
}
