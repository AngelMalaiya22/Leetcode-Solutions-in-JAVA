class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If count > 0, it's not the outermost opening parenthesis
                if (count > 0) {
                    sb.append(c);
                }
                count++;
            } else {
                count--;
                // If count > 0 after decrementing, it's not the outermost closing parenthesis
                if (count > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}