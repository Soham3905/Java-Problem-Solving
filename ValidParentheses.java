
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println(isValid(str));
        System.out.println(minAddToMakeValid("((())()())"));
    }

    static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                String current = "";
                while (stack.peek() != '(') {
                    current += stack.peek();
                    stack.pop();
                }
                stack.pop();
                for (char letter : current.toCharArray()) {
                    stack.push(letter);
                }
            } else {
                stack.push(ch);
            }
        }
        Stack<Character> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        String current = "";
        while (!stack1.isEmpty()) {
            current += stack1.peek();
            stack1.pop();
        }

        return current;
    }

    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
      if(x>y){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='b' && !stack.isEmpty() && stack.peek()=='a') {
                stack.pop();
                x += 5;
            }else{
                stack.push(s.charAt(i));
            }
        }
        Stack<Character> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        String current = "";
        while (!stack1.isEmpty()) {
            current += stack1.peek();
            stack1.pop();
        }
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) =='a' && !stack1.isEmpty() && stack1.peek()=='b') {
                stack1.pop();
                y += 4;
            }else{
                stack1.push(current.charAt(i));
            }
        }
        return x+y;
    }
    if(y > x){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) =='a' && !stack.isEmpty() && stack.peek()=='b') {
                stack.pop();
                x += 5;
            }else{
                stack.push(s.charAt(i));
            }
        }
        Stack<Character> stack1 = new Stack<>();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        String current = "";
        while (!stack1.isEmpty()) {
            current += stack1.peek();
            stack1.pop();
        }
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) =='b' && !stack1.isEmpty() && stack1.peek()=='a') {
                stack1.pop();
                y += 4;
            }else{
                stack1.push(current.charAt(i));
            }
        }
        return x+y;
      } 
      return 0;
    }

    // static int minInsertions(String s) {
    //    Stack<Character> stack = new Stack<>();
    //    for(char ch : s.toCharArray()){
    //     if (ch == ')') {
    //        if (!stack.isEmpty() && stack.peek() == ')') {
    //            stack.pop();
    //            if (!stack.isEmpty() && stack.peek() == '(') {
    //                stack.pop();
    //            }else{
    //             stack.push(')');
    //            }
    //        }else{
    //         stack.push(ch);
    //        }
    //     }else{
    //         stack.push(ch);
    //     }
    //    } 
    //    return stack.size();
    // }
    // static char newpeek(Stack<Character> first) {
    //   Stack<Character> second;
    //   second = first;
    //   if (!second.isEmpty()) {
    //     second.pop();
    //   }
    //   if (!second.isEmpty()) {
    //    return second.peek();
    //   }
    //   return 'a';    
    // }
}
