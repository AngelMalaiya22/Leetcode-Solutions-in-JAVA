import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007;
        int[] bitCounts = new int[31];

        // Step 1: Count total set bits at each bit position
        for (int num : nums) {
            for (int i = 0; i <= 30; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }

        long totalSum = 0;

        // Step 2: Greedily build the k largest possible numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit <= 30; bit++) {
                if (bitCounts[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCounts[bit]--;
                }
            }
            // Step 3: Add square modulo 10^9 + 7
            totalSum = (totalSum + (currentNum % MOD) * (currentNum % MOD)) % MOD;
        }

        return (int) totalSum;
    }
}