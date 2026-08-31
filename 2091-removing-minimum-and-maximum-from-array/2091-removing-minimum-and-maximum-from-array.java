class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int bothLeft = Math.max(min, max) + 1;
        int bothRight = n - Math.min(min, max);
        int maxLeftminRight = max + 1 + (n - min);
        int minLeftmaxRight = min + 1 + (n - max);
        return Math.min(Math.min(bothLeft,bothRight),Math.min(maxLeftminRight,minLeftmaxRight));
    }
}