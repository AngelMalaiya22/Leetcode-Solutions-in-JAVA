import java.util.*;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> invalid = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                seen.add(nums[i]);
                if (seen.contains(nums[i + 1])) {
                    invalid.add(nums[i + 1]);
                }
            }
        }
        seen.add(nums[nums.length - 1]);

        int c = 0;
        for (int x : seen) {
            if (!invalid.contains(x)) {
                c++;
            }
        }

        return c;
    }
}