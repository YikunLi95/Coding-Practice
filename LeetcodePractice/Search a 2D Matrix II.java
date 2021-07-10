class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // corner case
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // process
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
// TC:
