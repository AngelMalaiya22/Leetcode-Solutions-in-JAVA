class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Remove all islands connected to the boundary
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // If it's a boundary cell and contains land ('0')
                if ((r == 0 || r == m - 1 || c == 0 || c == n - 1) && grid[r][c] == 0) {
                    dfs(grid, r, c);
                }
            }
        }

        // Step 2: Count remaining closed islands
        int closedIslands = 0;
        for (int r = 1; r < m - 1; r++) {
            for (int c = 1; c < n - 1; c++) {
                if (grid[r][c] == 0) {
                    closedIslands++;
                    dfs(grid, r, c); // Sink the closed island
                }
            }
        }

        return closedIslands;
    }

    private void dfs(int[][] grid, int r, int c) {
        // Base case: Out of bounds or water ('1')
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }

        // Mark current land as visited by converting it to water
        grid[r][c] = 1;

        // Explore 4-directional neighbors
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
