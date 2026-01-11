
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int residuePrefixes(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int distinctChar = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(s.charAt(i - 1))) {
                set.add(s.charAt(i - 1));
                distinctChar += 1;
            }
            if ((i % 3) == distinctChar) {
                result += 1;
            }
        }
        return result;
    }

    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                set.add(nums[j]);
                if (set.contains(sum)) {
                    result += 1;
                }
            }
        }
        return result;
    }

    public long countPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        long result = 0;
        for (String word : words) {
            String hash = diff(word);
            result += map.getOrDefault(hash, 0);
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        return result;
    }

    public String diff(String word) {
        StringBuilder sb = new StringBuilder();
        int first = word.charAt(0) - 'a';
        for (char ch : word.toCharArray()) {
            int difference = (ch - 'a' - first + 26) % 26;
            sb.append(difference).append("_");
        }
        return sb.toString();
    }

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;

        int[] rightNearest = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightNearest[i] = n;
            } else {
                rightNearest[i] = stack.peek();
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        int[] leftNearest = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftNearest[i] = -1;
            } else {
                leftNearest[i] = stack.peek();
            }
            stack.add(i);
        }
        for (int i = 0; i < n; i++) {
            int currArea = heights[i] * (rightNearest[i] - leftNearest[i] - 1);
            ans = Math.max(ans, currArea);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] += arr[i - 1][j];
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        int result = 0;
        for (int[] row : arr) {
            int curr = largestRectangleArea(row);
            result = Math.max(result, curr);
        }
        return result;
    }

    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        while (i<=j) { 
            if (nums[i]%2!=0 && nums[j]%2==0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }else if (nums[i]%2==0) {
                i++;
            }else{
                j--;
            }
        }
        return nums;
    }
}
