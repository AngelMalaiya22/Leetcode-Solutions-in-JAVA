import java.util.HashSet;
class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {

        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        Set<Integer>resultSet=new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        for (int i : set1) 
        {
            if (set2.contains(i)) {
                resultSet.add(i);
            }
        }
        
        /*int[] result = resultSet.stream().mapToInt(Integer::intValue).toArray();
        return result;*/

        /*
        // retainAll()- Keeps only elements in set1 that are ALSO present in set2
        set1.retainAll(set2);   
        return set1.stream().mapToInt(Integer::intValue).toArray();
        */

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}

