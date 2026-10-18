import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Step 1: Precompute Pascal's Triangle for Combination C(n, k) % MOD
        comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Step 2: Compute total ways recursively and subtract 1 (exclude original)
        long totalWays = countWays(list);
        return (int) ((totalWays - 1 + MOD) % MOD);
    }

    private long countWays(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int val = nums.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        int nL = left.size();
        int nR = right.size();

        // Formula: C(nL + nR, nL) * leftWays * rightWays % MOD
        long waysToInterleave = comb[nL + nR][nL];
        long subResult = (leftWays * rightWays) % MOD;

        return (waysToInterleave * subResult) % MOD;
    }
}