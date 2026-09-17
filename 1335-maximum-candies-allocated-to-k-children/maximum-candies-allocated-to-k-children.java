class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = 0;
        
        for (int c : candies) {
            high = Math.max(high, c);
        }
        
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canAllocate(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean canAllocate(int[] candies, long k, int target) {
        long childrenCount = 0;
        
        for (int c : candies) {
            childrenCount += c / target;
            if (childrenCount >= k) {
                return true;
            }
        }
        
        return childrenCount >= k;
    }
}