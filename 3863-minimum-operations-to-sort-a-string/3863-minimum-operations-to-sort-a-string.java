class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) return 0;
        if (n == 2) return -1;
        if (n == 3) {
            if (s.charAt(0) == s.charAt(1)
                    && s.charAt(1) == s.charAt(2)) {
                return 0;
            }
        }

        char min = 'z';
        char max = 'a';
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c < min) {
                min = c;
                minCount = 1;
            } else if (c == min) {
                minCount++;
            }

            if (c > max) {
                max = c;
                maxCount = 1;
            } else if (c == max) {
                maxCount++;
            }
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min
                && maxCount == 1 && minCount == 1) {
            return 3;
        }

        return 2;
    }
}