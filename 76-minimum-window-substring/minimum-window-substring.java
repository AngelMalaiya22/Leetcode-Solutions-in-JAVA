class Solution {
    public String minWindow(String s, String t) {
        
        int unique = 0;
        int[] tFrequency = new int[128];

        for (char c : t.toCharArray()) {
            if (tFrequency[c] == 0) {
                ++unique;
            }

            ++tFrequency[c];
        }

        int start = 0;
        int end = 0;
        int minLength = s.length() + 1;
        int startIndex = -1;
        int endIndex = -1;

        int[] sFrequency = new int[128];

        while (end < s.length()) {
            char cEnd = s.charAt(end);
            ++sFrequency[cEnd];

            if (sFrequency[cEnd] == tFrequency[cEnd]) {
                --unique;
            }

            while (unique == 0) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    startIndex = start;
                    endIndex = end;
                }

                char cStart = s.charAt(start);

                if (sFrequency[cStart] == tFrequency[cStart]) {
                    ++unique;
                }

                --sFrequency[cStart];
                ++start;
            }

            ++end;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, endIndex + 1);
    }
}