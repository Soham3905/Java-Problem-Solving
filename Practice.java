
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

   public boolean isSorted(int[] nums,int n) {
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ans = 0;
        while (!isSorted(nums,n)) {
            ans++;
            int min = Integer.MAX_VALUE;
            int pos = -1;
            for (int j = 1; j < n; j++) {
                int sum = nums[j] + nums[j - 1];
                if (min > sum) {
                    min = sum;
                    pos = j;
                }
            }
            nums[pos - 1] = min;
            for (int k = pos; k < n - 1; k++) {
                nums[k] = nums[k + 1];
            }
            n--;
        }
        return ans;
    }

}
