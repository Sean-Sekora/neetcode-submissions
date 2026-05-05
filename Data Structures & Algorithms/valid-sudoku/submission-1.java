class Solution {
    char[][] board;
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) return false;
        this.board = board;
        for (int i = 0; i < 9; i++) {
            if (!validRow(i)) return false;
            if (!validColumn(i)) return false;
            if (i % 3 == 0 && !validBlock(i)) return false;
        }

        return true;
    }
    int[][] directions = new int[][]{{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};

    private boolean validBlock(int offset) {
        int row = offset;
        int col = 0;
        for (int i = 0; i <= 2; i++) {
            Set<Character> values = new HashSet<>();
            int count = 0;
            for (int[] direction : directions) {
                char val = board[row + direction[0]][col + direction[1]];
                if (val != '.') {
                    count++;
                    values.add(val);
                }
            }
            if (values.size() != count) {
                return false;
            }
            col += 3;
        }
        return true;
    }

    private boolean validRow(int row) {
        Set<Character> values = new HashSet<>();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            char val = board[row][i];
            if (val != '.') {
                count++;
                values.add(val);
            }
        }
        return values.size() == count;
    }

    private boolean validColumn(int col) {
        Set<Character> values = new HashSet<>();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            char val = board[i][col];
            if (val != '.') {
                count++;
                values.add(val);
            }
        }
        return values.size() == count;
    }
}
