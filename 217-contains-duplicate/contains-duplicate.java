/*class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i] == nums[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}*/
import java.util.HashSet;
class Solution 
{
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer>Myset=new HashSet<>(); 
        for(int i=0;i<nums.length;i++)
        {
            int element=nums[i];
            if(!Myset.add(element))
            {
                return true;
            }
        }
        return false;
    }
}