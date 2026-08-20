class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDo(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canDo(int[] nums,int k, int mid) {
        int subarrays = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > mid) {
                currentSum = num;
                subarrays++;
            } else {
                currentSum += num;
            }
            if (subarrays > k) {
                return false;
            }
        }
        return true;
    }
}