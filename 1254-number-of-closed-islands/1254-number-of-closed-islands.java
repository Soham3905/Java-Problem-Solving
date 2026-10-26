class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false) {
                    if (dfs(grid, visited, i, j, n, m)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        if (grid[i][j] == 1 || visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        boolean up = dfs(grid, visited, i - 1, j, n, m);
        boolean down = dfs(grid, visited, i + 1, j, n, m);
        boolean left = dfs(grid, visited, i, j - 1, n, m);
        boolean right = dfs(grid, visited, i, j + 1, n, m);

        return up && down && left && right;
    }
}