class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        // Made this array to collect the all right sum 
        int right[] = new int[nums.length];
        int prod1 = 1;
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--)
        {
            prod1 = prod1 * nums[i + 1];
            right[i] = prod1;
        }  

        // Made this array to collect the all left sum
        int left[] = new int[nums.length];
        int prod2 = 1;
        left[0] = 1;
        for(int i = 1; i < nums.length; i++)
        {
            prod2 = prod2 * nums[i - 1];
            left[i] = prod2;
        }

        // The final Array which contains the result
        int result[] = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            result[index++] = right[i] * left[i];
        }

        return result;
    }
}