// Pacific Atlantic Water Flow
class Solution {
    public int rows;
    public int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific
        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific, heights[0][col]);
        }

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific, heights[row][0]);
        }

        // Atlantic
        for (int col = 0; col < cols; col++) {
            dfs(heights, rows - 1, col, atlantic, heights[rows - 1][col]);
        }

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, cols - 1, atlantic, heights[row][cols - 1]);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }

        return res;
    }

     public void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            visited[row][col] ||
            heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;
        int height = heights[row][col];

        dfs(heights, row + 1, col, visited, height);
        dfs(heights, row - 1, col, visited, height);
        dfs(heights, row, col + 1, visited, height);
        dfs(heights, row, col - 1, visited, height);
    }
}
