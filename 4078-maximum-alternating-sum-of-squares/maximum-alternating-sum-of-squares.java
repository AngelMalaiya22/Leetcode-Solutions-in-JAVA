import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        // Compute squares for all numbers
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        
        // Sort squares in ascending order
        Arrays.sort(squares);
        
        // Number of negative positions is n / 2
        // Number of positive positions is n - (n / 2)
        int numNegative = n / 2;
        
        long totalScore = 0;
        
        // The smallest numNegative elements get subtracted
        for (int i = 0; i < numNegative; i++) {
            totalScore -= squares[i];
        }
        
        // The remaining largest elements get added
        for (int i = numNegative; i < n; i++) {
            totalScore += squares[i];
        }
        
        return totalScore;
    }
}