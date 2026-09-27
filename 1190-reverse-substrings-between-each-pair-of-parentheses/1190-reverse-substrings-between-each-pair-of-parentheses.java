class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                while (stack.peek() != '(') {
                    char pop = stack.pop();
                    queue.offer(pop);
                }
                stack.pop();
                while (!queue.isEmpty()) {
                    char poll = queue.poll();
                    stack.push(poll);
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}