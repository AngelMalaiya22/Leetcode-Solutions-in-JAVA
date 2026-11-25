
class Solution {

    public int maxLength(int[] nums) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < nums.length; j++) {

                int num = nums[j];

                product = product * num;

                gcd = findGCD(gcd, num);

                lcm = (lcm / findGCD(lcm, num)) * num;

                if (product == gcd * lcm) {

                    int length = j - i + 1;

                    ans = Math.max(ans, length);
                }
            }
        }

        return ans;
    }

    public int findGCD(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}