class Solution 
{
    public int search(int[] nums, int target) 
    {
        int low=0, mid, high= nums.length-1;
        int ans= -1;
        while(low<=high)
        {
            mid = low + (high - low) / 2;

            if(nums[mid]==target)
            {
                return mid;
            }

            if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && nums[mid]>target)
                {
                    high= mid-1;
                }
                else
                {
                    low= mid+1;
                }
            }
            else if(nums[mid]<target && nums[high]>=target)
            {
                low= mid+1;
            }
            else
            {
                high= mid-1;
            }
        }
        return -1;
    }
}


/* for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == target)
            {
                return i;
            }
        }
        return -1;*/