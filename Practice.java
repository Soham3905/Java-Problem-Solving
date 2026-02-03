
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        for(int i = -n/2 ; i <= n/2 ; i++){
            if(n%2==0 && i==0){
                continue;
            }else{
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public boolean helper(int ele){
        while(ele>0){
            int rem = ele%10;
            if(rem==0){
                return false;
            }
            ele /= 10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n/2; i++) {
            if(helper(i) && helper(n-i)){
                return new int[]{i,n-i};
            }
        }
        return new int[]{1,n-1};
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        if(dist==1){
            return nums[0]+nums[1]+nums[2];
        }
        long result = 0;
        for (int i = 1; i < n-dist; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int sum = 0;
            for (int j = i; j < i+dist; j++) {
                pq.add(nums[j]);
            }
            while (k-1>0) { 
                sum+=pq.poll();
                k--;
            }
            result = Math.min(result,sum);
        }
        return nums[0]+result;
    }

        public boolean isTrionic(int[] nums) {
        int n = nums.length;
        boolean a = false;
        boolean b = false;
        boolean c = false;

        int i = 0;

        while(i+1<n && nums[i]<nums[i+1]){
            a = true;
            i++;
        }
        while(i+1<n && nums[i]>nums[i+1]){
            b = true;
            i++;
        }
        while(i+1<n && nums[i]<nums[i+1]){
            c = true;
            i++;
        }
        return a && b && c && i==n-1;
    }

}
