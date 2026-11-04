class Solution 
{
    public int searchInsert(int[] nums, int target) 
    {
        int index=0,number=1;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]>=target)
           {
                return i;
           }
        }
        return nums.length;
    }
}