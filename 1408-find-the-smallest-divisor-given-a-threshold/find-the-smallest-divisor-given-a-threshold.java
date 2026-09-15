/*class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int divisor = 1;

        while (true) {
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + divisor - 1) / divisor;
            }

            if (sum <= threshold) {
                return divisor;
            }

            divisor++;
        }
    }
}*/


class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        
        // Find maximum element in nums to set upper bound
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        int ans = high;
        
        // Binary search for the smallest divisor
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (getSum(nums, mid) <= threshold) {
                ans = mid;      // Valid divisor found, try searching for a smaller one
                high = mid - 1;
            } else {
                low = mid + 1;  // Sum is too large, need a larger divisor
            }
        }
        
        return ans;
    }
    
    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // Formula for ceiling division: Math.ceil(num / divisor)
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}