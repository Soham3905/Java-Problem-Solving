class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                if ((ch == ')' && stack.peek() == '(') || 
                    (ch == '}' && stack.peek() == '{')|| 
                    (ch == ']' && stack.peek() == '[')) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}