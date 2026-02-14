
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[102][102];
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                dp[i][j] = -1;
            }
        }
        double ans = helper(dp, poured, query_row, query_glass);
        return Math.min(ans, 1);
    }

    public double helper(double[][] dp, int poured, int i, int j) {
        if (i < 0 || j < 0 || i < j) {
            return 0.0;
        }
        if (i == 0 && j == 0) {
            return poured;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        double leftUp = (helper(dp, poured, i - 1, j - 1) - 1) / 2.0;
        double rightUp = (helper(dp, poured, i - 1, j) - 1) / 2.0;
        if (leftUp < 0) {
            leftUp = 0.0;
        }
        if (rightUp < 0) {
            rightUp = 0.0;
        }
        return dp[i][j] = leftUp + rightUp;
    }

}
