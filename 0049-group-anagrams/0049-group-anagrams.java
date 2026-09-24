class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i]){
                continue;
            }
            List<String> list = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                if(isAnagrams(strs[i],strs[j])){
                    visited[j] = true;
                    list.add(strs[j]);
                }
            }
            list.add(strs[i]);
            result.add(list);
        }
        return result;
    }

    public boolean isAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
            arr[str2.charAt(i) - 'a']--;
        }
        for (int ele : arr) {
            if (ele != 0) {
                return false;
            }
        }
        return true;
    }
}