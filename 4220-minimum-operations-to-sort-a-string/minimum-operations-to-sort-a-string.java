class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // 1. Check if already sorted
        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;

        // 2. Length 2 and unsorted is impossible
        if (n == 2) return -1;

        // 3. Find global minChar and maxChar
        char minChar = s.charAt(0);
        char maxChar = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        // 4. Can sort in 1 operation
        if (first == minChar || last == maxChar) {
            return 1;
        }

        // 5. Check if minChar appears anywhere in s[0...n-2]
        boolean minInPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                minInPrefix = true;
                break;
            }
        }

        // Check if maxChar appears anywhere in s[1...n-1]
        boolean maxInSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                maxInSuffix = true;
                break;
            }
        }

        // If s[0] == maxChar and s[n-1] == minChar, but we can bring a min to 
        // the front or a max to the back in step 1, it only takes 2 operations.
        if (first == maxChar && last == minChar && !minInPrefix && !maxInSuffix) {
            return 3;
        }

        // 6. All other unsorted cases take 2 operations
        return 2;
    }
}