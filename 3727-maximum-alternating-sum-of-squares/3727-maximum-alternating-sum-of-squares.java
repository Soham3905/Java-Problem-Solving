class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        long a = 0;
        for (int i = 0; i < (n / 2); i++) a += nums[i];
        long b = 0;
        for (int i = n / 2; i < n; i++) b += nums[i];
        return b - a;
    }
}