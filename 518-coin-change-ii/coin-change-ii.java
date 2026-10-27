import java.util.Arrays;

class Solution {
    public int helper(int amount, int[] coins, int index, int[][] dp) {
        // Base case: successfully formed the target amount
        if (amount == 0) {
            return 1;
        }
        
        // Base case: index out of bounds or target amount went negative
        if (index >= coins.length || amount < 0) {
            return 0;
        }

        // Return memoized result if already computed
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Option 1: Take the current coin (if it fits)
        int take = 0;
        if (coins[index] <= amount) {
            take = helper(amount - coins[index], coins, index, dp);
        }

        // Option 2: Do not take the current coin, move to next index
        int notTake = helper(amount, coins, index + 1, dp);

        // Store and return result
        return dp[index][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) { 
        int[][] dp = new int[coins.length][amount + 1];
        
        // Fill memoization table with -1 to track unvisited states
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(amount, coins, 0, dp);
    }
}