// Island Perimeter
class Solution {
    public int rows;
    public int cols;

    public int islandPerimeter(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid, row, col);
                }
            }
        }

        return 0; 
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 1;
        } else if (grid[row][col] == -1) {
            return 0;
        }

        grid[row][col] = -1;
        int perimeter = 0;

        perimeter += dfs(grid, row + 1, col);
        perimeter += dfs(grid, row - 1, col);
        perimeter += dfs(grid, row, col + 1);
        perimeter += dfs(grid, row, col - 1);

        return perimeter;
    }
}