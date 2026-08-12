// Number of Islands
class Solution {
    public int rows;
    public int cols;

    public int numIslands(char[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
