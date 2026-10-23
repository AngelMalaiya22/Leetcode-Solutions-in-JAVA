class Solution {
    public int sortPermutation(int[] nums) {
        boolean sorted = true;
        int maxK = -1; // -1 represents all bits set to 1 (~0)

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                sorted = false;
                if (maxK == -1) {
                    maxK = nums[i];
                } else {
                    maxK &= nums[i];
                }
            }
        }

        // If nums is already sorted, return 0 as required
        if (sorted) {
            return 0;
        }

        return maxK;
    }
}