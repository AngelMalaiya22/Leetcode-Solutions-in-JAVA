import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        
        // 1. Precompute proper divisors for every possible substring length
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }
        
        // 2. Precompute minimum changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j, divisors[j - i + 1]);
            }
        }
        
        // 3. DP to partition into k semi-palindromes
        int INF = 1_000_000;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        // Base case: 1 partition
        for (int i = 2; i <= n; i++) {
            dp[1][i] = cost[0][i - 1];
        }
        
        // Fill DP table for 2 to k partitions
        for (int p = 2; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {
                // Split point m must allow (p - 1) substrings of length >= 2 before it,
                // and a substring of length >= 2 after it (m <= i - 2)
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][m] + cost[m][i - 1]);
                }
            }
        }
        
        return dp[k][n];
    }
    
    private int getSemiPalindromeCost(String s, int start, int end, List<Integer> divs) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;
        
        for (int d : divs) {
            int changes = 0;
            // Check each of the d interleaved groups
            for (int rem = 0; rem < d; rem++) {
                int left = start + rem;
                int right = end - (d - 1 - rem);
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }
        
        return minChanges;
    }
}