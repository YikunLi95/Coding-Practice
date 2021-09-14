class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    DFS(grid, rows, cols, r, c);
                }
            }
        }
        return res;
    }
    
    private void DFS(char[][] grid, int rows, int cols, int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        DFS(grid, rows, cols, r - 1, c);
        DFS(grid, rows, cols, r + 1, c);
        DFS(grid, rows, cols, r, c - 1);
        DFS(grid, rows, cols, r, c + 1);
    }
}
