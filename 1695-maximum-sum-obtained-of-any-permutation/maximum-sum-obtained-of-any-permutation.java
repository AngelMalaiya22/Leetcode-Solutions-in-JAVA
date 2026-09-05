class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] frequency = new int[nums.length + 1];

        for( int i=0; i< requests.length; i++){
            int start = requests[i][0];
            int end = requests[i][1];

            ++frequency[start];
            --frequency[end +1];
        }

        for(int i=1; i<frequency.length; i++){
            frequency[i] =frequency[i] + frequency[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(frequency);

        int i = nums.length-1;
        int j = frequency.length-1;

        long sum=0;
        int modulo=1000_000_007;


        while(i>=0){
            long val = (1L * nums[i] * frequency[j]) % modulo;
            sum = (sum + val) % modulo;
            i--;
            j--;
        }
        return (int) sum;
    }
}