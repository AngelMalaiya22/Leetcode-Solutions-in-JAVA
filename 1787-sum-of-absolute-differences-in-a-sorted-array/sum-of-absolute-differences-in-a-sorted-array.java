class Solution 
{
    public int[] getSumAbsoluteDifferences(int[] nums) 
    {
        /*int arr[]= new int[nums.length];
        int diff=0, sum=0, index=0;
        for(int i=0; i<nums.length; i++)
        {
            sum=0;
            for(int j=0; j<nums.length ; j++)
            {
                diff= nums[i] - nums[j];
                sum = sum + Math.abs(diff);
                diff=0;
            }
            arr[index++]=sum;
        }
        return arr;
        */
        int length=nums.length;
        int[] prefixSum = new int[length];

        prefixSum[0]=nums[0];

        for(int i=1;i<length;i++)
        {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int[] result = new int[length];

        for(int i=0;i<length;i++)
        {
            int leftSum= nums[i]*(i+1)-prefixSum[i];
            int remainingElements = length-i -1;
            int rightSum= prefixSum[length-1]-prefixSum[i]-(nums[i]*remainingElements);
            result[i]=leftSum + rightSum;
        }
        return result;
    }
}