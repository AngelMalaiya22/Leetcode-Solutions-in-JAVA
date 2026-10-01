class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        Stack<Integer> indexStack = new Stack<>();

        int start = -1;
        int end = 0;

        while (end <= heights.length) {
            while (!indexStack.isEmpty() && 
                (end == heights.length || heights[end] < heights[indexStack.peek()])
            ) {
                int index = indexStack.pop();
                int height = heights[index];

                start = indexStack.isEmpty() ? -1 : indexStack.peek();

                int width = end - start - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            indexStack.push(end);
            ++end;
        }

        return maxArea;
    }
}