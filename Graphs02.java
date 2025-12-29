
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graphs02 {

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited, isConnected);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, boolean[] visited, int[][] connected) {
        int n = connected.length;
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (connected[i][j] == 1 && visited[j] == false) {
                dfs(j, visited, connected);
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
                    dfsIsland(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsIsland(int i, int j, boolean[][] visited, char[][] grid) {
        int n = grid.length;
        visited[i][j] = true;
        // Right
        if (j + 1 < grid[0].length && visited[i][j + 1] == false && grid[i][j + 1] == '1') {
            dfsIsland(i, j + 1, visited, grid);
        }
        // Left
        if (j > 0 && visited[i][j - 1] == false && grid[i][j - 1] == '1') {
            dfsIsland(i, j - 1, visited, grid);
            visited[i][j - 1] = true;
        }
        // Up
        if (i > 0 && visited[i - 1][j] == false && grid[i - 1][j] == '1') {
            dfsIsland(i - 1, j, visited, grid);
        }
        // Down
        if (i + 1 < n && visited[i + 1][j] == false && grid[i + 1][j] == '1') {
            dfsIsland(i + 1, j, visited, grid);
            visited[i + 1][j] = true;
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfsList(0, visited, rooms);
        for (boolean ch : visited) {
            if (ch == false) {
                return false;
            }
        }
        return true;
    }

    private void dfsList(int i, boolean[] visited, List<List<Integer>> rooms) {
        visited[i] = true;
        for (int ele : rooms.get(i)) {
            if (visited[ele] == false) {
                dfsList(ele, visited, rooms);
            }
        }
    }

    static boolean ans;

    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (ans == false) {
                return ans;
            }
            if (visited[i] == -1) {
                bfs(i, visited, graph);
            }
        }
        return ans;
    }

    private void bfs(int i, int[] visited, int[][] graph) {
        visited[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int front = q.remove();
            for (int ele : graph[front]) {
                if (visited[ele] == visited[front]) {
                    ans = false;
                    return;
                }
                if (visited[ele] == -1) {
                    q.add(ele);
                    visited[ele] = 1 - visited[front];
                }
            }
        }
    }

}
