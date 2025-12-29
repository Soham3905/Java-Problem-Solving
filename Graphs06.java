
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Graphs06 {

    public static void main(String[] args) {

    }

    public class Pair {

        int node;
        int cost;

        public Pair(int node, int cost) {
            this.cost = cost;
            this.node = node;
        }
    }

    public class Triplet implements Comparable<Triplet> {

        int node;
        int cost;
        int stops;

        public Triplet(int node, int cost, int stops) {
            this.cost = cost;
            this.node = node;
            this.stops = stops;
        }

        @Override
        public int compareTo(Triplet other) {
            if (this.stops == other.stops) {
                return Integer.compare(this.cost, other.cost);
            }
            return this.stops - other.stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int prize = flight[2];
            adj.get(from).add(new Pair(to, prize));
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(src, 0, 0));
        while (!pq.isEmpty()) {
            Triplet t = pq.remove();
            if (t.stops >= k + 1) {
                continue;
            }
            for (Pair p : adj.get(t.node)) {
                int totalCost = t.cost + p.cost;
                if (ans[p.node] > totalCost) {
                    ans[p.node] = totalCost;
                    pq.add(new Triplet(p.node, totalCost, t.stops + 1));
                }
            }
        }
        if (ans[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return ans[dst];
    }

    public class Triplet1 implements Comparable<Triplet1> {

        int node;
        int parent;
        int wt;

        public Triplet1(int node, int parent, int wt) {
            this.node = node;
            this.parent = parent;
            this.wt = wt;
        }

        @Override
        public int compareTo(Triplet1 other) {
            if (this.wt == other.wt) {
                return this.node - other.node;
            }
            return this.wt - other.wt;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Triplet1> pq = new PriorityQueue<>();
        int n = points.length;
        boolean[] visited = new boolean[n];
        int sum = 0;
        pq.add(new Triplet1(0, -1, 0));
        while (!pq.isEmpty()) {
            Triplet1 top = pq.remove();
            int node = top.node;
            if (visited[node] == true) {
                continue;
            }
            int parent = top.parent;
            int wt = top.wt;
            sum += wt;
            visited[node] = true;
            for (int i = 0; i < n; i++) {
                if (i == node || i == parent) {
                    continue;
                }
                if (visited[i] == true) {
                    continue;
                }
                int x1 = points[node][0];
                int y1 = points[node][1];
                int x2 = points[i][0];
                int y2 = points[i][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pq.add(new Triplet1(i, node, dist));
            }
        }
        return sum;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
            // nth time relaxation for -ve detection
            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[u] + wt < dist[v]) {
                    // negative cycle detected
                    return -1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        if (max == Integer.MAX_VALUE) {
            return -1;
        }
        return max;
    }
}
