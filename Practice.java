
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

   public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    sum += Math.abs(matrix[i][j]);
                    matrix[i][j] = Math.abs(matrix[i][j]);
                    count++;
                } else {
                    sum += matrix[i][j];
                }
            }
        }
        if (count % 2 == 0) {
            return sum;
        } else {
            boolean flipped = false;

            for (int i = 0; i < n && !flipped; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == min) {
                        matrix[i][j] = -matrix[i][j];
                        flipped = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result += matrix[i][j];
                }
            }
        }
        return result;
    }

}
