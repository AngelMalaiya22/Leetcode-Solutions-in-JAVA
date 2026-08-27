class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
       /* int total=0, f=0;
        for(int i=0;i<nums.length;i++)
        {
            f=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    if(f<3)
                    {
                        f++;
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    total=total+f;
                    i=j;
                    break;
                }
            }
        }
        return total;*/

    
    if (nums.length <= 2) 
    {
        return nums.length;
    }

    int k = 2; 

    for (int i = 2; i < nums.length; i++) 
    {
        if (nums[i] != nums[k - 2]) 
        {
            nums[k] = nums[i];
            k++;
        }
    }

    return k;
    }
}