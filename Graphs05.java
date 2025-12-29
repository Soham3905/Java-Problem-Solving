
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graphs05 {

    public static void main(String[] args) {

    }

    public class Pair implements Comparable<Pair> {

        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.time == other.time) {
                return this.node - other.node;
            }
            return this.time - other.time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            if (top.time > ans[top.node]) {
                continue;
            }
            for (Pair p : adj.get(top.node)) {
                int totaltime = top.time + p.time;
                if (totaltime < ans[p.node]) {
                    ans[p.node] = totaltime;
                    pq.add(new Pair(p.node, totaltime));
                }
            }
        }
        int max = -1;
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    public class Pair1 implements Comparable<Pair1> {

        int node;
        double prob;

        Pair1(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair1 other) {
            if (this.prob == other.prob) {
                return this.node - other.node;
            }
            return Double.compare(this.prob, other.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair1>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            adj.get(u).add(new Pair1(v, w));
            adj.get(v).add(new Pair1(u, w));
        }
        double[] ans = new double[n];
        ans[start_node] = 1;
        PriorityQueue<Pair1> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair1(start_node, 1));
        while (!pq.isEmpty()) {
            Pair1 top = pq.remove();
            if (top.prob < ans[top.node]) {
                continue;
            }
            for (Pair1 p : adj.get(top.node)) {
                double totalprob = top.prob * p.prob;
                if (totalprob > ans[p.node]) {
                    ans[p.node] = totalprob;
                    pq.add(new Pair1(p.node, totalprob));
                }
            }
        }
        return ans[end_node];
    }

    public class Triplet implements Comparable<Triplet> {

        int row;
        int col;
        int effort;

        public Triplet(int row, int col, int effort) {
            this.col = col;
            this.effort = effort;
            this.row = row;
        }

        @Override
        public int compareTo(Triplet other) {
            if (this.effort == other.effort) {
                return this.row - other.row;
            }
            return this.effort - other.effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, 0, 0));
        while (!pq.isEmpty()) {
            Triplet top = pq.remove();
            int r = top.row;
            int c = top.col;
            int e = top.effort;
            int[] row = {-1, 0, 1, 0};
            int[] col = {0, -1, 0, 1};
            if (r == m - 1 && c == n - 1) {
                break;
            }
            for (int i = 0; i <= 3; i++) {
                int newRow = r + row[i];
                int newCol = c + col[i];
                if (newRow < 0 || newCol < 0 || newRow > m - 1 || newCol > n - 1) {
                    continue;
                }
                int effort = Math.abs(heights[r][c] - heights[newRow][newCol]);
                effort = Math.max(e, effort);
                if (ans[newRow][newCol] > effort) {
                    ans[newRow][newCol] = effort;
                    pq.add(new Triplet(newRow, newCol, effort));
                }
                // if (r > 0) { //going up
                //     int effort = Math.abs(heights[r][c] - heights[r - 1][c]);
                //     effort = Math.max(e, effort);
                //     if (ans[r - 1][c] > effort) {
                //         ans[r - 1][c] = effort;
                //         pq.add(new Triplet(r - 1, c, effort));
                //     }
                // }

                // if (c > 0) { //going left
                //     int effort = Math.abs(heights[r][c] - heights[r][c - 1]);
                //     effort = Math.max(e, effort);
                //     if (ans[r][c - 1] > effort) {
                //         ans[r][c - 1] = effort;
                //         pq.add(new Triplet(r, c - 1, effort));
                //     }
                // }
                // if (r < m - 1) { //going down
                //     int effort = Math.abs(heights[r][c] - heights[r + 1][c]);
                //     effort = Math.max(e, effort);
                //     if (ans[r + 1][c] > effort) {
                //         ans[r + 1][c] = effort;
                //         pq.add(new Triplet(r + 1, c, effort));
                //     }
                // }
                // if (c < n - 1) { //going right
                //     int effort = Math.abs(heights[r][c] - heights[r][c + 1]);
                //     effort = Math.max(e, effort);
                //     if (ans[r][c + 1] > effort) {
                //         ans[r][c + 1] = effort;
                //         pq.add(new Triplet(r, c + 1, effort));
                //     }
                // }
            }
        }
        return ans[m - 1][n - 1];
    }
}
