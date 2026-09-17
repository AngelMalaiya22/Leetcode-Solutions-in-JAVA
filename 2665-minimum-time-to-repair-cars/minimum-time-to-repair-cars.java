class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        
        int minRank = ranks[0];
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }
        
        long high = (long) minRank * cars * cars;
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canRepairAll(ranks, cars, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean canRepairAll(int[] ranks, int cars, long time) {
        long totalCars = 0;
        
        for (int r : ranks) {
            totalCars += (long) Math.sqrt(time / r);
            
            if (totalCars >= cars) {
                return true;
            }
        }
        
        return totalCars >= cars;
    }
}