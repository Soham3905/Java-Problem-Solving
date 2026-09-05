class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] MAX = new int[n];
        int[] MIN = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            MAX[i] = max;
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            MIN[i] = min;
        }
        for (int i = 0; i < n; i++) {
            if ((MAX[i] - MIN[i]) <= k) {
                return i;
            }
        }
        return -1;
    }
}