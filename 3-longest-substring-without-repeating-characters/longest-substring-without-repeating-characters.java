import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            if (lastSeen[currChar] >= left) {
                left = lastSeen[currChar] + 1;
            }

            lastSeen[currChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}