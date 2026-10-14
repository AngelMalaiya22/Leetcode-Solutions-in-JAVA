class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Step 1: Impossibility check
        if ((long) sum > (long) num * 9) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Step 2: Number of 9s needed
        int nines = sum / 9;
        int remainder = sum % 9;
        
        // Append all 9s
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        
        // Append remainder digit if non-zero
        if (remainder > 0) {
            sb.append(remainder);
        }
        
        // Step 3: Pad the rest of the string with '0's up to length 'num'
        while (sb.length() < num) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}