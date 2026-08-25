class Solution 
{
    public int maxArea(int[] height) 
    {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) 
        {
            int width = j - i; // Correct distance calculation
            int length;
            
            if (height[i] < height[j]) 
            {
                length = height[i];
                i++; // Advance left pointer
            } 
            else 
            {
                length = height[j];
                j--; // Shrink right pointer
            }
            
            int area = length * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}