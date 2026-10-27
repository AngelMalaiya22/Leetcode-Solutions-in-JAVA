import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        
        // Fill the entire grid with obstacles '#'
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], '#');
        }
        
        // Path construction:
        // 1. Traverse all columns in the first row: (0, 0) -> (0, n-1)
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        
        // 2. Traverse down the last column: (1, n-1) -> (m-1, n-1)
        for (int i = 1; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Convert char 2D array to String array output
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}