class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        /*for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if((nums[i]+nums[j]) == target)
                {
                    arr[0]=i;
                    arr[1]=j;
                    break;
                }
            }
        }*/
        HashMap<Integer, Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int diff=target-nums[i];
            if(map.containsKey(diff) == true)
            {
                int[] result=new int[2];
                result[0]=i;
                result[1]=map.get(diff);

                return result;
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}