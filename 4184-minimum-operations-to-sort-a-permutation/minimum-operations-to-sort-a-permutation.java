class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Find the index of 0
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < n; i++) {
            int expectedInc = (nums[zeroIdx] + i) % n;
            if (nums[(zeroIdx + i) % n] != expectedInc) {
                isIncreasing = false;
            }

            int expectedDec = (nums[zeroIdx] - i + n) % n;
            if (nums[(zeroIdx + i) % n] != expectedDec) {
                isDecreasing = false;
            }
        }

        if (isIncreasing) {
            int k = zeroIdx;
            return Math.min(k, n - k + 2);
        }

        if (isDecreasing) {
            int k = zeroIdx;
            return Math.min(n - k, k + 2);
        }

        return -1;
    }
}