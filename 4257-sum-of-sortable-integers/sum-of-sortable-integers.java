class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Iterate over all possible divisors k of n
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            if (isSortable(nums, n, k)) {
                totalSum += k;
            }
        }

        return totalSum;
    }

    private boolean isSortable(int[] nums, int n, int k) {
        int prevMax = Integer.MIN_VALUE;

        for (int block = 0; block < n / k; block++) {
            int L = block * k;
            int R = L + k - 1;

            int dropCount = 0;
            int dropIndex = -1;

            for (int i = L; i < R; i++) {
                if (nums[i] > nums[i + 1]) {
                    dropCount++;
                    dropIndex = i;
                }
            }

            int currentMin, currentMax;

            if (dropCount == 0) {
                // Block is already sorted
                currentMin = nums[L];
                currentMax = nums[R];
            } else if (dropCount == 1) {
                // Check if cyclic wrap-around is sorted
                if (nums[R] > nums[L]) {
                    return false;
                }
                currentMin = nums[dropIndex + 1];
                currentMax = nums[dropIndex];
            } else {
                // More than 1 drop means this block cannot be sorted by cyclic rotation
                return false;
            }

            // Ensure non-decreasing order across blocks
            if (currentMin < prevMax) {
                return false;
            }

            prevMax = currentMax;
        }

        return true;
    }
}