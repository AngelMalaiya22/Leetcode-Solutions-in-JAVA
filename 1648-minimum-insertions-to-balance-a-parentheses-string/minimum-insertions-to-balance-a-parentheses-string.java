class Solution {
    public int minInsertions(String s) {
        int openCount = 0; // Tracks unmatched '('
        int insertions = 0; // Tracks required insertions
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                // Check if there is a consecutive second ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Skip the next ')' since we consume a pair
                } else {
                    // Single ')' found, we need to insert one missing ')'
                    insertions++;
                }

                // Balance with an open '(' if available
                if (openCount > 0) {
                    openCount--;
                } else {
                    // No open '(' available, so we need to insert one '('
                    insertions++;
                }
            }
        }

        // Each remaining unmatched '(' needs two ')'
        insertions += openCount * 2;

        return insertions;
    }
}