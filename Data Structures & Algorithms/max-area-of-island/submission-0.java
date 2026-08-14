// Max Area of Island
class Solution {
    public int rows;
    public int cols;

    public int maxAreaOfIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int area = 0;
        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    area = dfs(grid, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;

        area += dfs(grid, row + 1, col);
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row, col + 1);
        area += dfs(grid, row, col - 1);

        return area;
    }
}
