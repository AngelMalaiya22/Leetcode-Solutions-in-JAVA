class Solution 
{
    public int countTriplets(int[] nums) 
    {
        int[] count = new int[1 << 16];
        
        for (int i = 0; i < nums.length; i++) 
        {
            for (int j = 0; j < nums.length; j++) 
            {
                count[nums[i] & nums[j]]++;
            }
        }
        
        int ans = 0;
        for (int x : nums) 
        {
            for (int v = 0; v < (1 << 16); v++) 
            {
                if ((x & v) == 0) 
                {
                    ans += count[v];
                }
            }
        }
        
        return ans;
    }
}