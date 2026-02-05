
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
           if (nums[i]>0) {
               result[i] = nums[(i+nums[i])%n];
           }else if(nums[i]<0){
            result[i] = nums[(i+(nums[i]+n))%n];
           }else{
            result[i] = nums[i];
           }
        }
        return result;
    }

}
