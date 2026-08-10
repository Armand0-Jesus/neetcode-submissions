// Word Search
class Solution {

    public char[][] board;
    public int rows;
    public int cols;

    public final int[] rowDir = {0, 1, 0, -1};
    public final int[] colDir = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        char originalChar = board[row][col];
        board[row][col] = '#';

        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + rowDir[direction];
            int nextCol = col + colDir[direction];

            if (backtrack(nextRow, nextCol, word, index + 1)) {
                board[row][col] = originalChar;
                return true;
            }
        }

        board[row][col] = originalChar;

        return false;
    }
}