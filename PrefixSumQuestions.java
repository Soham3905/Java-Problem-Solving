
import java.util.Arrays;
import java.util.HashMap;

public class PrefixSumQuestions {

    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] pre = new int[nums.length];
        int i = 0;
        pre[i] = nums[i];
        for (i = 1; i < nums.length; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }
        return pre;
    }

    public class NumArray {

        int[] arr;

        public NumArray(int[] nums) {
            arr = Arrays.copyOf(nums, nums.length);
            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return arr[right];
            }
            return arr[right] - arr[left - 1];
        }
    }

    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            if (i > 0) {
                leftSum = nums[i - 1];
            }
            int rightSum = nums[nums.length - 1] - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public long[] findPrefixScore(int[] nums) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        long[] max = new long[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max[i - 1] < arr[i]) {
                max[i] = arr[i];
            } else {
                max[i] = max[i - 1];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + max[i];
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];
        int[] ans = new int[nums.length];

        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        suff[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] pre = new int[nums.length];
        int[] ans = new int[queries.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        int index = 0;
        for (int target : queries) {
            {
                ans[index] = binarySearch(pre, target);
                index++;
            }
        }
        return ans;
    }

    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return start;
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] flight : bookings) {
            int first = flight[0];
            int last = flight[1];
            int seats = flight[2];
            ans[first - 1] += seats;
            if (last < n) {
                ans[last] -= seats;
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int ele : nums) {
            if (ele == k) {
                count += 1;
            }
            int remaining = ele - k;
            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return count;
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pre = new int[n + 1];
        int[] suff = new int[n + 1];
        pre[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                pre[i] += 1;
            }
        }
        suff[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = suff[i + 1];
            if (customers.charAt(i) == 'Y') {
                suff[i] += 1;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            pre[i] += suff[i];
        }
        int min = 0;
        for (int i = 0; i < n + 1; i++) {
            if (pre[min] > pre[i]) {
                min = i;
            }
        }
        return min;
    }
}
