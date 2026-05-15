class Solution {
    int rows, cols;
    char[][] board;
    char[] word;
    boolean[][] path;
    int[][] directions;
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;

        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word.toCharArray();
        this.directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.path = new boolean[rows][cols];
                if(dfs(0,r,c)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int r, int c) {
        if (i == word.length) return true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word[i] || path[r][c]) return false;

        path[r][c] = true;
        boolean result = false;
        for (int[] direction : directions) {
            if (dfs(i + 1, r + direction[0], c + direction[1])) result = true;
        }
        path[r][c] = false;

        return result;
    }
}
