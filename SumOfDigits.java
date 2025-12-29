
public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sum1(12345));
        System.out.println(sum2(12345));
    }

    static int sum1(int num) {
        int result = 0;
        while (num > 0) {
            int rem = num % 10;
            result += rem;
            num = num / 10;
        }
        return result;
    }

    static int sum2(int num) {
        if (num < 1) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int rem = num % 10;
        return rem + sum2(num / 10);
    }
}
