class Solution 
{
    public int robbery(int[] nums, int index, int[] dp)
    {
        if(index >= nums.length)
        {
            return 0;
        }
        else if(dp[index] != -1)
        {
            return dp[index];
        }

        int rob = robbery(nums, index+2, dp);
        int noRob = robbery(nums, index+1, dp);

        int ans = Math.max(nums[index] + rob, noRob);
        dp[index]=ans;
        return ans;
    }

    public int rob(int[] nums) 
    {
        int dp[]= new int[nums.length];
        Arrays.fill(dp, -1);
        return robbery(nums, 0, dp);
    }
}