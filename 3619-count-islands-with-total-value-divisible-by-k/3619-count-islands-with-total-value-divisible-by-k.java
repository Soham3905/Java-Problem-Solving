
class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    if (dfs(grid, visited, i, j, n, m) % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public long dfs(int[][] grid, boolean[][] visited,
                    int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0L;
        }

        if (grid[i][j] == 0 || visited[i][j]) {
            return 0L;
        }

        visited[i][j] = true;
        long sum = grid[i][j];

        sum += dfs(grid, visited, i - 1, j, n, m);
        sum += dfs(grid, visited, i + 1, j, n, m);
        sum += dfs(grid, visited, i, j - 1, n, m);
        sum += dfs(grid, visited, i, j + 1, n, m);

        return sum;
    }
}
