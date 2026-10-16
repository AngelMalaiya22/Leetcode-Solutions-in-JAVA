import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    // Segment Tree Node tracking count, sum of values, and sum of squares
    static class SegmentTree {
        int n;
        long[] sum;      // Sum of d(i) values in segment
        long[] sumSq;    // Sum of d(i)^2 values in segment
        long[] lazy;     // Lazy propagation tag for range addition

        public SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void push(int node, int start, int end) {
            if (lazy[node] == 0) return;

            long val = lazy[node];
            int mid = start + (end - start) / 2;
            int left = 2 * node + 1;
            int right = 2 * node + 2;

            apply(left, start, mid, val);
            apply(right, mid + 1, end, val);

            lazy[node] = 0;
        }

        private void apply(int node, int start, int end, long val) {
            long len = end - start + 1;
            val %= MOD;
            
            // New sumSq = sumSq + 2 * val * sum + len * val^2
            sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + len * val % MOD * val % MOD) % MOD;
            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        public void update(int node, int start, int end, int l, int r, long val) {
            if (l <= start && end <= r) {
                apply(node, start, end, val);
                return;
            }

            push(node, start, end);
            int mid = start + (end - start) / 2;
            int left = 2 * node + 1;
            int right = 2 * node + 2;

            if (l <= mid) update(left, start, mid, l, r, val);
            if (r > mid) update(right, mid + 1, end, l, r, val);

            sum[node] = (sum[left] + sum[right]) % MOD;
            sumSq[node] = (sumSq[left] + sumSq[right]) % MOD;
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        long totalSumOfSquares = 0;

        for (int j = 0; j < n; j++) {
            int prev = lastSeen.getOrDefault(nums[j], -1);
            
            // Add +1 to range [prev + 1, j]
            tree.update(0, 0, n - 1, prev + 1, j, 1);
            
            // Add the total sum of squares for all subarrays ending at j
            totalSumOfSquares = (totalSumOfSquares + tree.sumSq[0]) % MOD;
            
            lastSeen.put(nums[j], j);
        }

        return (int) totalSumOfSquares;
    }
}