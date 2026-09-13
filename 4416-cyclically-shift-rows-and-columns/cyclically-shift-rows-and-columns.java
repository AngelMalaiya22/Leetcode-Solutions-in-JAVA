class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] tempGrid = new int[n][n];

        // Step 1: Cyclically left shift each row
        for (int i = 0; i < n; i++) {
            int shift = rowShift[i] % n;
            for (int j = 0; j < n; j++) {
                int newCol = (j - shift + n) % n;
                tempGrid[i][newCol] = grid[i][j];
            }
        }

        int[][] result = new int[n][n];

        // Step 2: Cyclically upward shift each column
        for (int j = 0; j < n; j++) {
            int shift = colShift[j] % n;
            for (int i = 0; i < n; i++) {
                int newRow = (i - shift + n) % n;
                result[newRow][j] = tempGrid[i][j];
            }
        }

        return result;
    }
}