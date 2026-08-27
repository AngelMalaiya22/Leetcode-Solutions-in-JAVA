class Solution 
{
    public boolean checkDivisibility(int n) 
    {
        int temp = n;
        int sum = 0;
        int product = 1;

        while (temp > 0) 
        {
            int d = temp % 10;
            sum += d;
            product *= d;
            temp /= 10;
        }

        int totalSum = sum + product;

        return n % totalSum == 0;
    }
}