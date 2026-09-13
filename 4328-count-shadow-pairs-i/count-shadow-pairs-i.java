import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static class Node {
        int val;
        int freq;
        Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public long shadowPairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        long totalElementsInStack = 0;
        Deque<Node> stack = new ArrayDeque<>();

        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && stack.peek().val > nums[j]) {
                totalElementsInStack -= stack.pop().freq;
            }

            long equalCount = 0;
            if (!stack.isEmpty() && stack.peek().val == nums[j]) {
                equalCount = stack.peek().freq;
            }

            count += (totalElementsInStack - equalCount);

            if (!stack.isEmpty() && stack.peek().val == nums[j]) {
                stack.peek().freq++;
            } else {
                stack.push(new Node(nums[j], 1));
            }
            totalElementsInStack++;
        }

        return count;
    }
}