
public class Graphs07 {

    public static void main(String[] args) {

    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        // Floyd Warshall Algo
        for (int k = 0; k < n; k++) { // through k..
            for (int i = 0; i < n; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (j == k) {
                        continue;
                    }
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }

    static int[] parent;
    static int[] size;

    public int find(int a) { // returns the group leader of a
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            } else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n + 1]; // 1 to n nodes
        size = new int[n + 1]; // 1 to n nodes
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    union(i + 1, j + 1); // connecting group leaders of i+1 and j+1
                }
            }
        }
        int count = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

}
