
public class DynamicProgramming2 {

    public static void main(String[] args) {
        int[] val = {6, 3, 9, 25};
        int[] wt = {2, 2, 8, 9};
        int c = 9;
        int n = wt.length;
        int[][] dp3 = new int[n][c + 1];
        for (int[] dp31 : dp3) {
            for (int j = 0; j < dp3[0].length; j++) {
                dp31[j] = -1;
            }
        }
        System.out.println(knapsackunbounded(0, wt, val, c, dp3));
    }

    public static int knapsackunbounded(int index, int[] wt, int[] val, int capacity, int[][] dp3) {
        if (index == wt.length) {
            return 0;
        }
        if (dp3[index][capacity] != -1) {
            return dp3[index][capacity];
        }
        int skip = knapsackunbounded(index + 1, wt, val, capacity, dp3);
        if (wt[index] > capacity) {
            return dp3[index][capacity] = skip;
        }
        int take = val[index] + knapsackunbounded(index, wt, val, capacity - wt[index], dp3);
        return dp3[index][capacity] = Math.max(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = (int) coinChangeways(0, coins, amount, dp);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    private long coinChangeways(int i, int[] coins, int amount, long[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (i == coins.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        long skip = coinChangeways(i + 1, coins, amount, dp);
        if (coins[i] > amount) {
            return dp[i][amount] = skip;
        }
        long take = 1 + coinChangeways(i, coins, amount - coins[i], dp);
        return dp[i][amount] = Math.min(take, skip);
    }

    public int coinChangeTabulation(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                long skip = (i > 0) ? dp[i - 1][j] : (j == 0 ? 0 : Integer.MAX_VALUE);
                if (coins[i] > j) {
                    dp[i][j] = skip;
                } else {
                    long take = 1 + dp[i][j - coins[i]];
                    dp[i][j] = Math.min(take, skip);
                }
            }
        }
        int ans = (int) dp[coins.length - 1][amount];
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    public int coinChangeTabulationSpaceOptimize(int[] coins, int amount) {
        long[][] dp = new long[2][amount + 1]; // i-1 = 0 & i = 1 ->>> only in dp(most most imp) not array(here array is coins)
        for (int i = 0; i < coins.length; i++) { // here coins.length is written
            for (int j = 0; j < amount + 1; j++) {
                long skip = (i > 0) ? dp[0][j] : (j == 0 ? 0 : Integer.MAX_VALUE);
                if (coins[i] > j) {
                    dp[1][j] = skip;
                } else {
                    long take = 1 + dp[1][j - coins[i]];
                    dp[1][j] = Math.min(take, skip);
                }
            }
            // copy paste 1st row to 0th row
            // for (int j = 0; j < amount+1; j++) {
            //     dp[0][j] = dp[1][j];
            // }
            System.arraycopy(dp[1], 0, dp[0], 0, amount + 1);
        }
        int ans = (int) dp[1][amount];
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    // static int sum;
    // public int findTargetSumWays(int[] nums, int target) {
    //     sum = 0;
    //     for (int ele : nums) {
    //         sum += ele;
    //     }
    //     int[][] dp = new int[nums.length][2 * sum + 1];
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < dp[0].length; j++) {
    //             dp[i][j] = -1;
    //         }
    //     }
    //     return ways(0, nums, 0, target, dp);
    // }
    // private int ways(int i, int[] nums, int result, int target, int[][] dp) {
    //     if (i == nums.length) {
    //         if (result == target) {
    //             return 1;
    //         } else {
    //             return 0;
    //         }
    //     }
    //     if (dp[i][result + sum] != -1) {
    //         return dp[i][result + sum];
    //     }
    //     int add = ways(i + 1, nums, result + nums[i], target, dp);
    //     int sub = ways(i + 1, nums, result - nums[i], target, dp);
    //     return dp[i][result + sum] = add + sub;
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        StringBuilder x = new StringBuilder(text1);
        StringBuilder y = new StringBuilder(text2);
        return lcs(text1.length() - 1, text2.length() - 1, x, y, dp);
    }

    private int lcs(int i, int j, StringBuilder text1, StringBuilder text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1, text1, text2, dp);
        } else {
            return dp[i][j] = Math.max(lcs(i - 1, j, text1, text2, dp), lcs(i, j - 1, text1, text2, dp));
        }
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

    public int longestCommonSubsequenceTablation2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequenceTablation2SpaceOp(String text1, String text2) {
        int[][] dp = new int[2][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[1][j] = 1 + dp[0][j - 1];
                } else {
                    dp[1][j] = Math.max(dp[1][j - 1], dp[0][j]);
                }
            }
            for (int j = 0; j <= text2.length(); j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][text2.length()];
    }

    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequenceTablation2SpaceOp(s, reverse(s));
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        return s;
    }

    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    public int minDistance(String word1, String word2) {
        int ans = longestCommonSubsequence(word1, word2);
        return (word1.length() - ans) + (word2.length() - ans);
    }

    public int editDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return minimumDistance(m - 1, n - 1, a, b, dp);
    }

    private int minimumDistance(int i, int j, StringBuilder a, StringBuilder b, int[][] dp) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = minimumDistance(i - 1, j - 1, a, b, dp);
        }
        int del = minimumDistance(i - 1, j, a, b, dp);
        int ins = minimumDistance(i, j - 1, a, b, dp);
        int rep = minimumDistance(i - 1, j - 1, a, b, dp);
        return dp[i][j] = 1 + Math.min(del, Math.min(ins, rep));
    }

    public int editDistanceTabulation(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = (i >= 1 && j >= 1) ? dp[i - 1][j - 1] : ((i == 0) ? j : i);
                int q = (i >= 1) ? dp[i - 1][j] : j;
                int r = (j >= 1) ? dp[i][j - 1] : i;
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = p;
                } else {
                    dp[i][j] = 1 + Math.min(q, Math.min(r, p));
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
