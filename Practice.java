
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public String reverseByType(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                stack1.push(ch);
            } else {
                stack2.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                sb.append(stack1.pop());
            } else {
                sb.append(stack2.pop());
            }
        }
        return sb.toString();
    }

    public int minimumK(int[] nums) {
        int n = nums.length;
        int result = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long count = 0;
            for (int ele : nums) {
                count += Math.ceil(ele / mid);
            }
            if (count <= (long) mid * mid) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

}
