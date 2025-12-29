
public class BinarytoDecimal {

    public static void main(String[] args) {
        System.out.println(bintodec(1010101010));
    }

    static int bintodec(int num) {
        int result = 0;
        int i = 0;
        while (num > 0) {
            int rem = num % 10;
            result = result + (int) (rem * Math.pow(2, i));
            i++;
            num = num / 10;
        }
        return result;
    }
}
