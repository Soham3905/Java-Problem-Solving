
public class ProductOfDigits {

    public static void main(String[] args) {
        System.out.println(product1(12345));
        System.out.println(product2(10045));
    }

    static int product1(int num) {
        int result = 1;
        while (num > 0) {
            int rem = num % 10;
            result *= rem;
            num = num / 10;
        }
        return result;
    }

    static int product2(int num) {
        if (num < 1) {
            return 1;
        }
        if (num == 1) {
            return 1;
        }
        int rem = num % 10;
        return rem * product2(num / 10);
    }
}
