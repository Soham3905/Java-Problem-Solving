
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class HeapQuestions {

    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        System.out.println(kthSmallestElement(arr, k));
        System.out.println(Arrays.toString(nearlySorted(arr, k)));
    }

    public static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static int[] nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[arr.length];
        int index = 0;
        for (int ele : arr) {
            pq.add(ele);
            if (pq.size() > k) {
                ans[index] = pq.remove();
                index++;
            }
        }
        while (!pq.isEmpty()) {
            ans[index] = pq.remove();
            index++;
        }
        return ans;
    }

    // public class Pair{
    // int x;
    // int y;
    // Pair(int x, int y){
    // this.x = x;
    // this.y = y;
    // }
    // }
    // public int[][] kClosest(int[][] points, int k) {
    // if(points.length == k){
    // return points;
    // }
    // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    // HashMap<Integer,Pair> map = new HashMap<>();
    // for (int i = 0; i < points.length; i++) {
    // int x = points[i][0];
    // int y = points[i][1];
    // int d2 = x*x + y*y;
    // pq.add(d2);
    // map.put(d2, new Pair(x, y));
    // if (pq.size()>k) {
    // pq.remove();
    // }
    // }
    // int[][] ans = new int[k][2];
    // for (int i = 0; i < k; i++) {
    // int dist = pq.remove();
    // Pair pt = map.get(dist);
    // ans[i][0] = pt.x;
    // ans[i][1] = pt.y;
    // }
    // return ans;
    // }
    public class Triplet implements Comparable<Triplet> {

        int d;
        int x;
        int y;

        Triplet(int d, int x, int y) {
            this.d = d;
            this.x = x;
            this.y = y;
        }

        public int getD() {
            return d;
        }

        @Override
        public int compareTo(Triplet other) {
            return this.d - other.d;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        if (points.length == k) {
            return points;
        }
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int d = x * x + y * y;
            pq.add(new Triplet(d, x, y));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Triplet t = pq.remove();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }
        return ans;
    }

    public class Pair implements Comparable<Pair> {

        int ele;
        int diff;

        Pair(int ele, int diff) {
            this.ele = ele;
            this.diff = diff;
        }

        public int getDiff() {
            return diff;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.diff == other.diff) {
                return this.ele - other.ele;
            }
            return this.diff - other.diff;
        }

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int ele : arr) {
            int diff = Math.abs(x - ele);
            pq.add(new Pair(ele, diff));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            ans.add(p.ele);
        }
        Collections.sort(ans);
        return ans;
    }

    public class Paired implements Comparable<Paired> {

        int ele;
        int freq;

        public Paired(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        public int getFreq() {
            return freq;
        }

        @Override
        public int compareTo(Paired other) {
            if (this.freq == other.freq) {
                return other.ele - this.ele;
            }
            return this.freq - other.freq;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Paired> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
            pq.add(new Paired(key, freq));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Paired p = pq.remove();
            ans[i] = p.ele;
        }
        return ans;
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Paired> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
            pq.add(new Paired(key, freq));
        }
        int[] ans = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty()) {
            Paired p = pq.remove();
            while (p.freq != 0) {
                ans[index] = p.ele;
                index++;
                p.freq--;
            }
        }
        return ans;
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int ele : stones) {
            pq.add(ele);
        }
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            if (first != second) {
                pq.add(first - second);
            }
        }
        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.peek();
        }
    }

    public int min_cost_to_connect_ropes(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for (int ele : arr) {
            pq.add(ele);
        }
        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();
            cost += (first + second);
            pq.add(cost);
        }
        return cost;
    }

    public class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    public boolean isMaxHeap(Node root) {
        int n = size(root);
        return isHOP(root) && isCBT(root, n, 0);
    }

    public int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public boolean isHOP(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.value < root.left.value) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.value < root.right.value) {
                return false;
            }
        }
        return isHOP(root.left) && isHOP(root.right);
    }

    public boolean isCBT(Node root, Integer n, int i) {
        if (root == null) {
            return true;
        }
        if (i >= n) {
            return false;
        }
        return isCBT(root.left, n, 2 * i + 1) && isCBT(root.right, n, 2 * i + 2);
    }

    // class MedianFinder {
    // ArrayList<Integer> list;
    // public MedianFinder() {
    // list = new ArrayList<>();
    // }
    // public void addNum(int num) {
    // list.add(num);
    // }
    // public double findMedian() {
    // Collections.sort(list);
    // int n = list.size();
    // if (n%2!=0) {
    // return list.get(n/2);
    // }else{
    // return (list.get(n/2)+list.get((n/2)-1))/2.0;
    // }
    // }
    // }
    public class MedianFinder {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
            } else {
                if (num < maxHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }

            // Balance Heaps
            if (maxHeap.size() == minHeap.size() + 2) {
                int top = maxHeap.remove();
                minHeap.add(top);
            }
            if (minHeap.size() == maxHeap.size() + 2) {
                int top = minHeap.remove();
                maxHeap.add(top);
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }

    public class Triplet02 implements Comparable<Triplet02> {

        int ele;
        int row;
        int col;

        Triplet02(int ele, int row, int col) {
            this.col = col;
            this.ele = ele;
            this.row = row;
        }

        @Override
        public int compareTo(Triplet02 other) {
            return this.ele - other.ele;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = {0, Integer.MAX_VALUE};
        PriorityQueue<Triplet02> pq = new PriorityQueue<>();
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int ele = nums.get(i).get(0);
            pq.add(new Triplet02(ele, i, 0));
            max = Math.max(max, ele);
        }
        while (true) {
            Triplet02 t = pq.remove();
            int ele = t.ele;
            int row = t.row;
            int col = t.col;
            // Update the minimum range
            if (max - ele < ans[1] - ans[0]) {
                ans[0] = ele;
                ans[1] = max;
            }
            if (col == nums.get(row).size() - 1) {
                break;
            }
            int next = nums.get(row).get(col + 1);
            max = Math.max(max, next);
            pq.add(new Triplet02(next, row, col + 1));
        }
        return ans;
    }

}
