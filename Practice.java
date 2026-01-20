
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int ele = nums.get(i);
            for (int j = 0; j < ele; j++) {
                if ((j | (j + 1))==nums.get(i)) {
                    ans[i] = j;
                    break;
                }
            }
            if (ans[i]==0) {
                ans[i] = -1;
            }
        }
        return ans;
    }

}
