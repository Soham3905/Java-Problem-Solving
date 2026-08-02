class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            sum += piles[i];
        }
        int alice = solve(0, n - 1, piles, dp);
        int bob = sum - alice;
        return alice > bob;
    }

    public int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return arr[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = arr[i] + Math.min(solve(i + 2, j, arr, dp), solve(i + 1, j - 1, arr, dp));
        int take_j = arr[j] + Math.min(solve(i + 1, j - 1, arr, dp), solve(i, j - 2, arr, dp));
        return dp[i][j] = Math.max(take_i, take_j);
    }
}