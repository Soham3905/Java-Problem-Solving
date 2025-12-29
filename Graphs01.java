
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graphs01 {

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited, isConnected);
                count++;
            }
        }
        return count;
    }

    private void bfs(int i, boolean[] visited, int[][] connected) {
        int n = connected.length;
        visited[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < n; j++) {
                if (connected[front][j] == 1 && visited[j] == false) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        bfsList(0, visited, rooms);
        for (boolean ch : visited) {
            if (ch == false) {
                return false;
            }
        }
        return true;
    }

    private void bfsList(int i, boolean[] visited, List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int ele : rooms.get(front)) {
                if (visited[ele] == false) {
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        visited[source] = true;
        bfsList2(source, visited, adj, destination);
        return visited[destination] != false;
    }

    private void bfsList2(int source, boolean[] visited, List<List<Integer>> adj, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int ele : adj.get(front)) {
                if (visited[ele] == false) {
                    visited[ele] = true;
                    q.add(ele);
                }
                if (ele == destination) {
                    return;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][grid[0].length];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfsIsland(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public class Pair {

        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    private void bfsIsland(int i, int j, boolean[][] visited, char[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int a = p.row;
            int b = p.col;
            // Right
            if (b + 1 < grid[0].length && visited[a][b + 1] == false && grid[a][b + 1] == '1') {
                q.add(new Pair(a, b + 1));
                visited[a][b + 1] = true;
            }
            // Left
            if (b > 0 && visited[a][b - 1] == false && grid[a][b - 1] == '1') {
                q.add(new Pair(a, b - 1));
                visited[a][b - 1] = true;
            }
            // Up
            if (a > 0 && visited[a - 1][b] == false && grid[a - 1][b] == '1') {
                q.add(new Pair(a - 1, b));
                visited[a - 1][b] = true;
            }
            // Down
            if (a + 1 < n && visited[a + 1][b] == false && grid[a + 1][b] == '1') {
                q.add(new Pair(a + 1, b));
                visited[a + 1][b] = true;
            }
        }
    }

}
