
public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    static int fact(int num) {
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
}
