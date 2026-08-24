class Solution 
{
    public int minStartValue(int[] nums) 
    {
        int startValue = 1;
        while (true)
        {
            boolean flag = true;
            int sum = startValue;

            for (int i = 0; i < nums.length; i++)
            {
                sum = sum + nums[i];

                if (sum < 1)
                {
                    flag = false;
                    break;
                }
            }

            if (flag == true)
            {
                return startValue;
            }

            startValue++;
        }
    }
}