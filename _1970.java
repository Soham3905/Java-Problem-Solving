
import java.util.LinkedList;
import java.util.Queue;

public class _1970 {

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int start = 0;
        int end = cells.length - 1;
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canCross(mid, cells, row, col)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public boolean canCross(int mid, int[][] cells, int row, int col) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < mid; i++) {
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }

        Queue<int[]> pq = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                pq.offer(new int[]{0, i});
                visited[0][i] = true;
            }
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            if (r == row - 1) {
                return true;
            }
            for (int dir[] : directions) {
                int newrow = r + dir[0];
                int newcol = c + dir[1];
                if (newrow >= 0 && newcol >= 0 && newrow <= row - 1 && newcol <= col - 1 && grid[newrow][newcol] == 0 && !visited[newrow][newcol]) {
                    visited[newrow][newcol] = true;
                    pq.offer(new int[]{newrow, newcol});
                }
            }
        }
        return false;
    }
}
