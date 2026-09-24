class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        int min = nums[0];  //Calculated the minimum element
        for (int i = 0; i < nums.length; i++) 
        {
            if (min > nums[i]) 
            {
                min = nums[i];
            }
        }

        int max = nums[0];  //Calculatedthe maximum element
        for (int i = 0; i < nums.length; i++) 
        {
            if (max < nums[i]) 
            {
                max = nums[i];
            }
        }

        int len = max - min + 1;  // Calculated the array length 
        int arr[] = new int[len]; // Decleared the new array

        for (int i = 0; i < nums.length; i++)  //Counting frequeny of every element and if element is not present then it is storing zero in it 
        {
            int index = nums[i] - min;    //value of arr-min
            arr[index]++;
        }

        for (int i = arr.length - 1; i >= 0; i--)  
        {
            if (arr[i] > 0) 
            {
                k = k - arr[i];
                if (k <= 0) //Got the kth largest element
                {
                    return i + min; 
                }
            }
        }

        return -1;
    }
}