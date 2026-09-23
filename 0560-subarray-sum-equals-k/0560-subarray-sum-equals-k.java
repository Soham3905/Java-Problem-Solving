class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            if (map.containsKey(pre[i] - k)) {
                count += map.get(pre[i] - k);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return count;
    }
}