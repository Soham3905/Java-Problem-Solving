
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {

    public static void main(String[] args) {
        int[] val = {5, 3, 9, 16};
        int[] wt = {1, 2, 8, 10};
        int c = 8;
        int n = wt.length;
        // i is varying from 0 to n-1 and capacity is varying from 0 to capacity
        int[][] dp3 = new int[n][c + 1];
        for (int[] dp31 : dp3) {
            for (int j = 0; j < dp3[0].length; j++) {
                dp31[j] = -1;
            }
        }
        System.out.println(knapsack0_1(0, wt, val, c, dp3));
        int[] nums = {8, 5, 2, 4};
        int target = 16;
        int[][] dp4 = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp4[0].length; j++) {
                dp4[i][j] = -1;
            }
        }

        System.out.println(suubsetSum(0, nums, target, dp4));
    }

    // static int[] dp;
    // public int fibo(int n) {
    //     if (n <= 1) {
    //         return n;
    //     }
    //     if (dp[n] != 0) {
    //         return dp[n];
    //     }
    //     int ans = fibo(n - 1) + fibo(n - 2);
    //     dp[n] = ans;
    //     return ans;
    // }
    // public int fib(int n) {
    //     dp = new int[n + 1];
    //     return fibo(n);
    // }
    public int fiboIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int index = 0;
        return Math.min(minCost(cost, index, dp), minCost(cost, index + 1, dp));
    }

    private int minCost(int[] cost, int index, int[] dp) {
        if (index == cost.length - 1 || index == cost.length - 2) {
            return cost[index];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans = cost[index] + Math.min(minCost(cost, index + 1, dp), minCost(cost, index + 2, dp));
        dp[index] = ans;
        return dp[index];
    }

    public int minCostClimbingStairsTabulation(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robMemoization(nums, 0, dp);
    }

    private int robMemoization(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int take = nums[index] + robMemoization(nums, index + 2, dp);
        int skip = robMemoization(nums, index + 1, dp);
        return dp[index] = Math.max(take, skip);
    }

    public int robTabulation(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        switch (nums.length) {
            case 1 -> {
                return nums[0];
            }
            case 2 -> {
                return Math.max(nums[0], nums[1]);
            }
            case 3 -> {
                return Math.max(Math.max(nums[0], nums[1]), nums[2]);
            }
        }
        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }
        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(dp2[0], nums[2]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], nums[i + 1] + dp2[i - 2]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }

    public int friendsPairing(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return friendsPairing(n, dp);
    }

    private int friendsPairing(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = friendsPairing(n - 1, dp) + (n - 1) * friendsPairing(n - 2, dp);
    }

    public int friendsPairingTabulation(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsMemoization(n, dp);
    }

    private int climbStairsMemoization(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = climbStairsMemoization(n - 1, dp) + climbStairsMemoization(n - 2, dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePaths(0, 0, m - 1, n - 1, dp);
    }

    private int uniquePaths(int srow, int scol, int erow, int ecol, int[][] dp) {
        if (srow == erow && scol == ecol) {
            return 1;
        }
        if (srow == erow + 1 || scol == ecol + 1) {
            return 0;
        }
        if (dp[srow][scol] != 0) {
            return dp[srow][scol];
        }
        int rightways = uniquePaths(srow, scol + 1, erow, ecol, dp);
        int downways = uniquePaths(srow + 1, scol, erow, ecol, dp);
        return dp[srow][scol] = rightways + downways;
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[m - 1].length;
        int[][] dp = new int[m][n];
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, m - 1, n - 1, dp);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int srow, int scol, int erow, int ecol, int[][] dp) {
        if (obstacleGrid[erow][ecol] == 1) {
            return 0;
        }
        if (srow == erow && scol == ecol) {
            return 1;
        }
        if (srow == erow + 1 || scol == ecol + 1) {
            return 0;
        }
        if (obstacleGrid[srow][scol] == 1) {
            return 0;
        }
        if (dp[srow][scol] != 0) {
            return dp[srow][scol];
        }
        int rightways = uniquePathsWithObstacles(obstacleGrid, srow, scol + 1, erow, ecol, dp);
        int downways = uniquePathsWithObstacles(obstacleGrid, srow + 1, scol, erow, ecol, dp);
        return dp[srow][scol] = rightways + downways;
    }

    // Wrong
    // public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[m - 1].length;
    //     if (obstacleGrid[0][0] == 1) {
    //         return 0;
    //     }
    //     int[][] dp = new int[m][n];
    //     for (int j = 0; j < n; j++) {
    //         if (obstacleGrid[0][j] != 1) {
    //             dp[0][j] = 1;
    //         } else {
    //             dp[0][j] = 0;
    //         }
    //     }
    //     for (int i = 1; i < m; i++) {
    //         if (obstacleGrid[i][0] != 1) {
    //             dp[i][0] = 1;
    //         } else {
    //             dp[i][0] = 0;
    //         }
    //     }
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             if (obstacleGrid[i][j] != 1) {
    //                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //             } else {
    //                 dp[i][j] = 0;
    //             }
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minSquares(n, dp);
    }

    public int minSquares(int n, int[] dp) {
        if (isPerfect(n)) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int count = minSquares(i * i, dp) + minSquares(n - i * i, dp);
            mini = Math.min(mini, count);
        }
        return dp[n] = mini;
    }

    private boolean isPerfect(int n) {
        int sqrt = (int) (Math.sqrt(n));
        return sqrt * sqrt == n;
    }

    public int numSquaresTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (isPerfect(i)) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    int count = dp[j * j] + dp[i - (j * j)];
                    min = Math.min(min, count);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    public static int knapsack0_1(int index, int[] wt, int[] val, int capacity, int[][] dp3) {
        if (index == wt.length) {
            return 0;
        }
        if (dp3[index][capacity] != -1) {
            return dp3[index][capacity];
        }
        int skip = knapsack0_1(index + 1, wt, val, capacity, dp3);
        if (wt[index] > capacity) {
            return dp3[index][capacity] = skip;
        }
        int take = val[index] + knapsack0_1(index + 1, wt, val, capacity - wt[index], dp3);
        return dp3[index][capacity] = Math.max(take, skip);
    }

    public int knapsack0_1Tabulation(int[] wt, int[] val, int capacity) {
        int[][] dp = new int[wt.length][capacity + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                int skip = (i > 0) ? dp[i - 1][j] : 0;
                if (wt[i] > j) {
                    dp[i][j] = skip;
                } else {
                    int pick = val[i];
                    pick += (i > 0) ? dp[i - 1][j - wt[i]] : 0;
                    dp[i][j] = Math.max(pick, skip);
                }
            }
        }
        return dp[wt.length - 1][capacity];
    }

    public static boolean suubsetSum(int i, int[] nums, int target, int[][] dp4) {
        if (i == nums.length) {
            return target == 0;
        }
        if (dp4[i][target] != -1) {
            return dp4[i][target] == 1;
        }
        boolean ans;
        boolean skip = suubsetSum(i + 1, nums, target, dp4);
        if (nums[i] > target) { // valid only for +ve elements.elements..agar -ve elements diye hain que me toh ye conition nahi likhna. 
            ans = skip;
        } else {
            boolean take = suubsetSum(i + 1, nums, target - nums[i], dp4);
            ans = take || skip;
        }
        if (ans == true) {
            dp4[i][target] = 1;
        } else {
            dp4[i][target] = 0;
        }
        return ans;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return suubsetSum(0, nums, target, dp);
    }

    public boolean canPartitionTabulation(int[] nums) {
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                boolean ans;
                boolean skip = (i>0) ? (dp[i-1][j] == 1) : (j==0);
                if (nums[i] > j) { // valid only for +ve elements.elements..agar -ve elements diye hain que me toh ye conition nahi likhna. 
                    ans = skip;
                } else {
                    boolean take = (i>0) ? (dp[i-1][j-nums[i]] == 1) : (j==0);
                    ans = take || skip;
                }
                if (ans == true) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[nums.length-1][target] == 1;
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target + 1];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = (int) longestSubsequence(0, nums, target, dp);
        if (ans < 0) {
            return -1;
        } else {
            return ans;
        }
    }

    private int longestSubsequence(int i, List<Integer> nums, int target, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (i == nums.size()) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        int skip = longestSubsequence(i + 1, nums, target, dp);
        if (nums.get(i) > target) {
            return dp[i][target] = skip;
        }
        int take = 1 + longestSubsequence(i + 1, nums, target - nums.get(i), dp);

        return dp[i][target] = Math.max(take, skip);
    }

}
