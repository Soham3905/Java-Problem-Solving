class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }
        for (int ele : set) {
            if (!set.contains(ele - 1)) {
                int count = 1;
                int num = ele + 1;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}