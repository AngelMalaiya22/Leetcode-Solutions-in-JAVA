class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;

        int odd = 0;
        int even = 1;
        int sum = 0;
        int count = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 != 0) {
                count = (count + even) % MOD;
                odd++;
            } else {
                count = (count + odd) % MOD;
                even++;
            }
        }

        return count;
    }
}