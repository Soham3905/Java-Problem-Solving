class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        int diff = solve(0, stoneValue, dp);
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public int solve(int i, int[] arr, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result = Integer.MIN_VALUE;
        result = Math.max(result, arr[i] - solve(i + 1, arr, dp));
        if (i + 1 < arr.length) {
            result = Math.max(result, arr[i] + arr[i + 1] - solve(i + 2, arr, dp));
        }
        if (i + 2 < arr.length) {
            result = Math.max(result, arr[i] + arr[i + 1] + arr[i + 2] - solve(i + 3, arr, dp));
        }
        return dp[i] = result;
    }
}