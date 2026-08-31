import java.util.Arrays;

class Solution 
{
    public int numRescueBoats(int[] people, int limit) 
    {
        Arrays.sort(people);
        
        int pass = 0;
        int j = people.length - 1;

        for (int i = 0; i <= j; j--) {
            if (people[i] + people[j] <= limit) {
                i++; 
            }
            pass++; 
        }

        return pass;
    }
}