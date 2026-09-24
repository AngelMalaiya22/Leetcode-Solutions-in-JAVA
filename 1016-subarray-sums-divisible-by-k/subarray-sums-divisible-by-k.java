class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Array to store frequency of remainders (0 to k-1)
        int[] remainderCount = new int[k];
        
        // Base case: prefix sum of 0 has remainder 0 (count = 1)
        remainderCount[0] = 1;
        
        int prefixSum = 0;
        int result = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            // Calculate normalized remainder
            int rem = prefixSum % k;
            if (rem < 0) {
                rem += k;
            }
            
            // If this remainder was seen before, add its frequency to result
            result += remainderCount[rem];
            
            // Increment the count of this remainder
            remainderCount[rem]++;
        }
        
        return result;
    }
}