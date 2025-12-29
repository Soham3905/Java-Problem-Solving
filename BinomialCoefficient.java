
public class BinomialCoefficient {

    public static void main(String[] args) {
        System.out.println(binomialcoef(10, 8));
    }

    static int factorial(int num) {
        if (num < 0) {
            return -1;
        }
        if (num == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

    static float binomialcoef(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_n_r = factorial(n - r);
        float ans = fact_n / (fact_r * fact_n_r);
        return ans;
    }
}
