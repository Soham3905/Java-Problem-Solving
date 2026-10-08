class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                sb.append(s.substring(k + 1, i));
                k = i + 1;
            }
        }
        return sb.toString();
    }
}