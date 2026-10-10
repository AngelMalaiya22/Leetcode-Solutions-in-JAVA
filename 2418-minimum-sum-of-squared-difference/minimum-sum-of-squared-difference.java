class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        
        // Step 1: Calculate initial absolute differences and find the maximum difference
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        
        // Step 2: Bucket differences in a frequency array
        int[] count = new int[maxDiff + 1];
        for (int diff : diffs) {
            count[diff]++;
        }
        
        // Step 3: Combine total operations allowed
        long k = (long) k1 + k2;
        
        // Step 4: Reduce largest differences greedily
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) continue;
            
            if (k >= count[d]) {
                // We can reduce all elements of difference 'd' to 'd - 1'
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                // We can only reduce 'k' elements of difference 'd' to 'd - 1'
                count[d - 1] += k;
                count[d] -= k;
                k = 0; // All operations used
            }
        }
        
        // Step 5: Calculate total sum of squared differences
        long result = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                result += (long) count[d] * d * d;
            }
        }
        
        return result;
    }
}