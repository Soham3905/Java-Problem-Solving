
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        String lcs = "";

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs = s1.charAt(i - 1) + lcs;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        int sum = 0;
        int p = 0, q = 0;

        while (p < n && q < lcs.length()) {
            if (s1.charAt(p) == lcs.charAt(q)) {
                p++;
                q++;
            } else {
                sum += s1.charAt(p);
                p++;
            }
        }
        while (p < n) {
            sum += s1.charAt(p++);
        }

        int r = 0, s = 0;

        while (r < m && s < lcs.length()) {
            if (s2.charAt(r) == lcs.charAt(s)) {
                r++;
                s++;
            } else {
                sum += s2.charAt(r);
                r++;
            }
        }
        while (r < m) {
            sum += s2.charAt(r++);
        }

        return sum;
    }
}


}
