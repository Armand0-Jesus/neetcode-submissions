// Search a 2D Matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int botton = rows - 1;
        int row = -1;

        while (top <= botton) {
            int mid = top + (botton - top) / 2;

            if (target < matrix[mid][0]) {
                botton = mid - 1;
            } else if (target > matrix[mid][cols - 1]) {
                top = mid + 1;
            } else {
                row = mid;
                break;
            }
        }
        
        if (row == -1) {
            return false;
        }

        int left = 0;
        int right = cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
