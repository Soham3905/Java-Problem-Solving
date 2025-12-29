
public class DynamicProgramming3 {

    public static void main(String[] args) {

    }

    public int print_longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        StringBuilder str = new StringBuilder("");
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if ((text1.charAt(i - 1) == text2.charAt(j - 1))) {
                str.append(text1.charAt(i - 1));
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(str.reverse());
        return dp[text1.length()][text2.length()];
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = k;
            while (j < n) {
                if (i == j) {
                    dp[i][j] = 1;
                    count++;
                } else if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                        count++;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] == 1) {
                            dp[i][j] = 1;
                            count++;
                        }
                    }
                }
                i++;
                j++;
            }
        }
        return count;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        int first = 0;
        int second = 0;
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = k;
            while (j < n) {
                if (i == j) {
                    dp[i][j] = 1;
                    max = Math.max(max, j - i);
                    first = i;
                    second = j;
                } else if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                        max = Math.max(max, j - i);
                        first = i;
                        second = j;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] == 1) {
                            dp[i][j] = 1;
                            max = Math.max(max, j - i);
                            first = i;
                            second = j;
                        }
                    }
                }
                i++;
                j++;
            }
        }
        StringBuilder str = new StringBuilder("");
        for (int i = first; i <= second; i++) {
            str.append(s.charAt(first));
        }
        return str.toString();
    }

    public int longest_Common_Substring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int longestCommonSubsequenceTablation(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                int p = (i >= 1 && j >= 1) ? dp[i - 1][j - 1] : 0;
                int q = (j >= 1) ? dp[i][j - 1] : 0;
                int r = (i >= 1) ? dp[i - 1][j] : 0;
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + p;
                } else {
                    dp[i][j] = Math.max(q, r);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }

    public int length_shortestCommonSupersequence(String str1, String str2) {
        return str1.length() + str2.length() - longestCommonSubsequenceTablation(str1, str2);
    }

    public String print_lcs(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        StringBuilder str = new StringBuilder("");
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if ((text1.charAt(i - 1) == text2.charAt(j - 1))) {
                str.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return str.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = print_lcs(str1, str2);
        int i = 0;
        int j = 0;
        int k = 0;
        String ans = "";
        while (i < str1.length() && j < str2.length() && k < lcs.length()) {
            while (str1.charAt(i) != lcs.charAt(k)) {
                ans += str1.charAt(i);
                i++;
            }
            while (str2.charAt(j) != lcs.charAt(k)) {
                ans += str2.charAt(j);
                j++;
            }
            ans += lcs.charAt(k);
            i++;
            j++;
            k++;
        }
        while (i < str1.length()) {
            ans += str1.charAt(i);
            i++;
        }
        while (j < str2.length()) {
            ans += str2.charAt(j);
            j++;
        }
        return ans;
    }

    
}
