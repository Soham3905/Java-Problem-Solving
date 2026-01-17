
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int ans = Math.min(helper(hBars), helper(vBars));
        return ans * ans;
    }

    public int helper(int[] bars) {
        int result = 1;
        int count = 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result + 1;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(m);
        for (int ele : hFences) {
            list1.add(ele);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(n);
        for (int ele : vFences) {
            list2.add(ele);
        }

        long result = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                int diff = Math.abs(list1.get(j) - list1.get(i));
                set.add(diff);
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                int diff = Math.abs(list2.get(j) - list2.get(i));
                if (set.contains(diff)) {
                    result = Math.max(result, diff);
                }
            }
        }

        if (result == 0) {
            return -1;
        }
        return (int) ((result * result) % 1_000_000_007);
    }

    class Pair implements Comparable<Pair> {

        int x;
        int y;
        int q;

        public Pair(int x, int y, int q) {
            this.x = x;
            this.y = y;
            this.q = q;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.q != other.q) {
                return other.q - this.q;
            }
            if (this.x != other.x) {
                return this.x - other.x;
            }
            return this.y - other.y;
        }
    }

    public int[] bestTower(int[][] towers, int[] center, int radius) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int[] t : towers) {
            int dist = Math.abs(t[0] - center[0]) + Math.abs(t[1] - center[1]);
            if (dist <= radius) {
                pq.add(new Pair(t[0], t[1], t[2]));
            }
        }

        if (pq.isEmpty()) {
            return new int[]{-1, -1};
        }

        Pair best = pq.poll();
        return new int[]{best.x, best.y};
    }

    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                set.add(nums[i]);
            }
        }

        return set.size();
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int maxX = Math.min(topRight[i][0], topRight[j][0]);
                int minY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int maxY = Math.min(topRight[i][1], topRight[j][1]);

                if (minX < maxX && minY < maxY) {
                    int len = Math.min(maxX - minX, maxY - minY);
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans * ans;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            ListNode temp = l1;
            while (temp != null) {
                list1.add(temp.val);
                temp = temp.next;
            }

            temp = l2;
            while (temp != null) {
                list2.add(temp.val);
                temp = temp.next;
            }

            Collections.reverse(list1);
            Collections.reverse(list2);

            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();

            for (int x : list1) {
                str1.append(x);
            }
            for (int x : list2) {
                str2.append(x);
            }

            long a = Long.parseLong(str1.toString());
            long b = Long.parseLong(str2.toString());
            long c = a + b;

            String str3 = Long.toString(c);

            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for (int i = str3.length() - 1; i >= 0; i--) {
                curr.next = new ListNode(str3.charAt(i) - '0');
                curr = curr.next;
            }

            return dummy.next;
        }
    }

}
