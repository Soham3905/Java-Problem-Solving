class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2)
            return false;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 2; i < n + 1; i++) {
            set.add(pre[i - 2] % k);
            if (set.contains(pre[i] % k)) {
                return true;
            }
        }
        return false;
    }
}