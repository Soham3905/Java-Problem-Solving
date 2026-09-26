class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                StringBuilder sb = new StringBuilder();
                while (s.charAt(j) != ')') {
                    sb.append(s.charAt(j));
                    j++;
                }
                if (map.containsKey(sb.toString())) {
                    result.append(map.get(sb.toString()));
                } else {
                    result.append("?");
                }
                i = j;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}