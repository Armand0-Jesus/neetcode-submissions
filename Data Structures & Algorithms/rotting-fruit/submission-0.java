// Rotting Fruit
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] time = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    dfs(grid, time, row, col, 0);
                }
            }
        }

        int timeRequired = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    if (time[row][col] == Integer.MAX_VALUE) {
                        return -1;
                    }

                    timeRequired = Math.max(timeRequired, time[row][col]);
                }
            }
        }

        return timeRequired;
    }

    public void dfs(int[][] grid, int[][] time, int row, int col, int currentTime) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
            grid[row][col] == 0 || currentTime >= time[row][col]) {
            return;
        }

        time[row][col] = currentTime;

        dfs(grid, time, row - 1, col, currentTime + 1);
        dfs(grid, time, row + 1, col, currentTime + 1);
        dfs(grid, time, row, col - 1, currentTime + 1);
        dfs(grid, time, row, col + 1, currentTime + 1);
    }
}