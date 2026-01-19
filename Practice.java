
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] rowSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            rowSum[i][0] = mat[i][0];
            for (int j = 1; j < m; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + mat[i][j];
            }
        }

        int[][] colSum = new int[n][m];
        for (int j = 0; j < m; j++) {
            colSum[0][j] = mat[0][j];
            for (int i = 1; i < n; i++) {
                colSum[i][j] = colSum[i - 1][j] + mat[i][j];
            }
        }

        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxPossible = Math.min(n - i, m - j);
                for (int k = maxPossible; k > maxSize; k--) {
                    if (helper(i, j, k, mat, rowSum, colSum, threshold)) {
                        maxSize = k;
                        break;
                    }
                }
            }
        }
        return maxSize;
    }

    public boolean helper(int sr, int sc, int size, int[][] grid, int[][] rowSum, int[][] colSum, int threshold) {
        int result = 0;
        for (int i = sr; i < sr + size; i++) {
            int sum = rowSum[i][sc + size - 1] - (sc > 0 ? rowSum[i][sc - 1] : 0);
            result += sum;
        }
        return result <= threshold;
    }

}
