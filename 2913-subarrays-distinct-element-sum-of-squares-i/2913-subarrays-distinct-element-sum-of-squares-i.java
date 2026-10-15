class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] arr = new int[j - i + 1];
                int index = 0;
                for (int k = i; k <= j; k++) {
                    arr[index] = nums.get(k);
                    index++;
                }
                HashSet<Integer> set = new HashSet<>();
                for (int ele : arr) {
                    set.add(ele);
                }
                result += set.size() * set.size();
            }
        }
        return result;
    }
}