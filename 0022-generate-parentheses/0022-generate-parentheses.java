class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        return helper(2*n,sb,list);
    }

    public List<String> helper(int n, StringBuilder sb, List<String> list) {
        if (n == 0) {
            if (isValid(sb.toString())) {
                list.add(sb.toString());
            }
            return list;
        }

        sb.append('(');
        helper(n-1,sb,list);
        sb.delete(sb.length()-1,sb.length());

        sb.append(')');
        helper(n-1,sb,list);
        sb.delete(sb.length()-1,sb.length());
        
        return list;
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if (ch == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}