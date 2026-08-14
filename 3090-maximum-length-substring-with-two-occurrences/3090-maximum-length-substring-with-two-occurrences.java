class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.get(s.charAt(j)) > 2) {
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}