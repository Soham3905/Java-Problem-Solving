class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] MAX = new int[n];
        int[] MIN = new int[n];
        for (int i = 0; i < n; i++) {
            MAX[i] = Math.max(nums[i], max);
            max = Math.max(nums[i], max);
        }
        for (int i = n-1; i >= 0; i--) {
            MIN[i] = Math.min(nums[i], min);
            min = Math.min(nums[i], min);
        }
        for (int i = 0; i < n; i++) {
            if ((MAX[i] - MIN[i]) <= k) {
                return i;
            }
        }
        return -1;
    }
}