
public class Magic_Squares_In_Grid {

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (magicsquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean magicsquare(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[row + i][col + j];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                } else {
                    seen[val] = true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != 15) {
                return false;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (grid[row][col + j] + grid[row + 1][col + j] + grid[row + 2][col + j] != 15) {
                return false;
            }
        }
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != 15) {
            return false;
        }
        if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != 15) {
            return false;
        }
        return true;
    }
}
