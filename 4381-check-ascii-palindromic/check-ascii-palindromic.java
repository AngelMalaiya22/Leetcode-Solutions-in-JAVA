class Solution 
{
    public boolean isPalindromic(String s) 
    {
        StringBuilder binary_string= new StringBuilder();
        for(int i=0; i<s.length();i++)
        {
            int ascii= s.charAt(i);

            StringBuilder b= new StringBuilder();
            for(int j=0; j<8 ;j++)
            {
                b.append(ascii%2);
                ascii= ascii/2;
            }
            binary_string.append(b.reverse().toString());
        }

        String bStr= binary_string.toString();
        int left=0;
        int right=bStr.length()-1;

        while(left<right)
            {
                if(bStr.charAt(left) != bStr.charAt(right))
                {
                    return false;
                }
                left++;
                right--;
            }
        return true;
    }
}