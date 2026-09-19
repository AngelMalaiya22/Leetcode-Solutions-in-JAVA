import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100;
            int d2 = (i / 10) % 10;
            int d3 = i % 10;

            count[d1]--;
            count[d2]--;
            count[d3]--;

            if (count[d1] >= 0 && count[d2] >= 0 && count[d3] >= 0) {
                list.add(i);
            }

            count[d1]++;
            count[d2]++;
            count[d3]++;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}