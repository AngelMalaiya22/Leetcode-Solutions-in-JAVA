import java.math.BigInteger;

class Solution {
    public int sumDecoded(long[] nums) {
        BigInteger mod = BigInteger.valueOf(1000000007);
        BigInteger sum = BigInteger.ZERO;

        for (long num : nums) {
            int width = (int) (num % 10);
            String s = String.valueOf(num / 10);

            BigInteger base = new BigInteger(s.substring(0, width));
            BigInteger exp = new BigInteger(s.substring(width));

            BigInteger res = base.modPow(exp, mod);
            sum = sum.add(res).mod(mod);
        }

        return sum.intValue();
    }
}