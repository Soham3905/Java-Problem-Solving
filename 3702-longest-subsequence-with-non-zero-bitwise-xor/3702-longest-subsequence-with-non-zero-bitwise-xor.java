class Solution {
    public int longestSubsequence(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        
        if (xorSum != 0) {
            return nums.length;
        } else {
            boolean allZeros = true;
            for (int num : nums) {
                if (num != 0) {
                    allZeros = false;
                    break;
                }
            }
            return allZeros ? 0 : nums.length - 1;
        }
    }
}