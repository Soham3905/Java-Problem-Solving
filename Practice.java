
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] result = new int[n];
    //     for (int i = 0; i <= n - k; i++) {
    //         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //         for (int j = i; j < i + k; j++) {
    //             pq.add(nums[j]);
    //         }
    //         result[i] = pq.poll();
    //     }
    //     return result;
    // }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            while (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k-1) {
                result[i-(k-1)] = nums[dq.getFirst()];
            }
        }
        return result;
    }
}
