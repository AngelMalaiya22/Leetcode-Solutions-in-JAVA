class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // Found an unvisited land cell (positive integer)
                if (grid[r][c] > 0) {
                    long totalSum = dfs(grid, r, c);
                    if (totalSum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int r, int c) {
        // Base case: Out of bounds or water/visited cell
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        // Add current cell value and mark as visited by setting to 0
        long currentVal = grid[r][c];
        grid[r][c] = 0;

        // Recursively sum 4-directionally connected land cells
        currentVal += dfs(grid, r + 1, c);
        currentVal += dfs(grid, r - 1, c);
        currentVal += dfs(grid, r, c + 1);
        currentVal += dfs(grid, r, c - 1);

        return currentVal;
    }
}