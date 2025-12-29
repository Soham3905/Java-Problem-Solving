
import java.util.Arrays;

public class DynamicProgramming5 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}};
        int n = arr.length;
        System.out.println(mcm_min(0, n - 1, arr));
        System.out.println(mcm_max(0, n - 1, arr));
        int[] nums = {1, 2, 3, 4};
        int m = nums.length;
        int[][] dp = new int[m - 1][m - 1];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(mcm(0, m - 2, nums, dp));
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(mcm_Tabulation(arr2));
    }

    public static int mcm(int i, int j, int[] nums, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min_cost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = nums[i] * nums[k + 1] * nums[j + 1];
            int total_cost = mcm(i, k, nums, dp) + mcm(k + 1, j, nums, dp) + x;
            min_cost = Math.min(min_cost, total_cost);
        }
        return dp[i][j] = min_cost;
    }

    public static int mcm_Tabulation(int[] arr2) {
        int l = arr2.length;
        int[][] dp = new int[l - 1][l - 1];
        for (int i = l - 2; i >= 0; i--) {
            for (int j = 0; j <= l - 2; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    int min_cost = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int x = arr2[i] * arr2[k + 1] * arr2[j + 1];
                        int total_cost = dp[i][k] + dp[k + 1][j] + x;
                        min_cost = Math.min(min_cost, total_cost);
                    }
                    dp[i][j] = min_cost;
                }
            }
        }
        return dp[0][l - 2];
    }

    public static int mcm_min(int i, int j, int[][] arr) {
        if (i == j) {
            return 0;
        }
        int min_cost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i][0] * arr[j][1] * arr[k][1];
            int total_cost = mcm_min(i, k, arr) + mcm_min(k + 1, j, arr) + x;
            min_cost = Math.min(min_cost, total_cost);
        }
        return min_cost;
    }

    public static int mcm_max(int i, int j, int[][] arr) {
        if (i == j) {
            return 0;
        }
        int max_cost = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int x = arr[i][0] * arr[j][1] * arr[k][1];
            int total_cost = mcm_max(i, k, arr) + mcm_max(k + 1, j, arr) + x;
            max_cost = Math.max(max_cost, total_cost);
        }
        return max_cost;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int[] LIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }
        return dp;
    }

    public int[] LIS_reverse(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j >= i + 1; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }
        return dp;
    }

    public int minimumMountainRemovals(int[] nums) {
        int[] dp1 = LIS(nums);
        int[] dp2 = LIS_reverse(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) { // Important..
                int length = dp1[i] + dp2[i] - 1;
                max = Math.max(length, max);
            }
        }
        if (max < 3) {
            return 0;
        }
        return nums.length - max;
    }

    public class Envelop implements Comparable<Envelop> {

        int width;
        int height;

        public Envelop(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(Envelop other) {
            if (this.width == other.width) {
                return other.height - this.height;
            }
            return this.width - other.width;
        }

    }

    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelop[] arr = new Envelop[n];
        for (int i = 0; i < n; i++) {
            int w = envelopes[i][0];
            int h = envelopes[i][1];
            arr[i] = new Envelop(w, h);
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j].height < arr[i].height) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        int i;
        for (i = 0; i < cuts.length; i++) {
            arr[i] = cuts[i];
        }
        arr[i++] = 0;
        arr[i] = n;
        Arrays.sort(arr);
        int m = arr.length;
        // i = 1 to m-2 and j = m-2 to 1
        int[][] dp = new int[m - 1][m - 1]; // consider including 0
        for (int p = 0; p < m - 1; p++) {
            for (int j = 0; j < m - 1; j++) {
                dp[p][j] = -1;
            }
        }
        return cost(1, arr.length - 2, arr, dp);
    }

    public int cost(int i, int j, int[] arr, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int length = arr[j + 1] - arr[i - 1];
            int totalcost = cost(i, k - 1, arr, dp) + cost(k + 1, j, arr, dp) + length;
            min = Math.min(totalcost, min);
        }
        return dp[i][j] = min;
    }

}
