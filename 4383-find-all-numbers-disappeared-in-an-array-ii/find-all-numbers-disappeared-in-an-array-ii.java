class Solution 
{
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) 
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        long prev= (long) lower -1;
        for(int num:nums)
            {
                if(num<lower)
                {
                    continue;
                }
                if(num>upper)
                {
                    break;
                }
                if(num>prev+1)
                {
                    result.add(Arrays.asList((int)(prev+1), num-1));
                }
                prev =num;
            }
        if(prev < upper)
        {
            result.add(Arrays.asList((int)(prev+1), upper));
        }
        return result;
    }
}