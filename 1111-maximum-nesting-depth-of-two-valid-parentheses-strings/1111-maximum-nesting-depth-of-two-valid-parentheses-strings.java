class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                ans[i] += count % 2;
                count++;
            } else {
                count--;
                ans[i] += count % 2;
            }
        }
        return ans;
    }
}