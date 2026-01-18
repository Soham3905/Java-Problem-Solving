
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    v++;
                } else {
                    c++;
                }
            }
        }

        if (c > 0) {
            return (int) Math.floor(v / c);
        } else {
            return 0;
        }
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int result = 0;
        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }
        Arrays.sort(machines, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                result = Math.max(machines[i][1], result);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (costs[i] + costs[j] < budget) {
                    result = Math.max(result,
                            capacity[i] + capacity[j]);
                }
            }
        }
        return result;
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] rowSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            rowSum[i][0] = grid[i][0];
            for (int j = 1; j < m; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }

        int[][] colSum = new int[n][m];
        for (int j = 0; j < m; j++) {
            colSum[0][j] = grid[0][j];
            for (int i = 1; i < n; i++) {
                colSum[i][j] = colSum[i - 1][j] + grid[i][j];
            }
        }

        int maxSize = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxPossible = Math.min(n - i, m - j);
                for (int k = maxPossible; k > maxSize; k--) {
                    if (isMagic(i, j, k, grid, rowSum, colSum)) {
                        maxSize = k;
                        break;
                    }
                }
            }
        }
        return maxSize;
    }

    public boolean isMagic(int sr, int sc, int size, int[][] grid, int[][] rowSum, int[][] colSum) {
        int target = rowSum[sr][sc + size - 1] - (sc > 0 ? rowSum[sr][sc - 1] : 0);

        for (int i = sr; i < sr + size; i++) {
            int sum = rowSum[i][sc + size - 1] - (sc > 0 ? rowSum[i][sc - 1] : 0);
            if (sum != target) {
                return false;
            }
        }

        for (int j = sc; j < sc + size; j++) {
            int sum = colSum[sr + size - 1][j] - (sr > 0 ? colSum[sr - 1][j] : 0);
            if (sum != target) {
                return false;
            }
        }

        int d1 = 0;
        for (int k = 0; k < size; k++) {
            d1 += grid[sr + k][sc + k];
        }
        if (d1 != target) {
            return false;
        }

        int d2 = 0;
        for (int k = 0; k < size; k++) {
            d2 += grid[sr + size - 1 - k][sc + k];
        }

        return d2 == target;
    }

}
