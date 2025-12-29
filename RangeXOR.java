
public class RangeXOR {

    public static void main(String[] args) {
        System.out.println(findXor(8));
        // range xor for a, b = xor(b) ^ xor(a-1)
        int a = 3;
        int b = 9;

        int ans = findXor(b) ^ findXor(a - 1);
        System.out.println(ans);

    }

    static int findXor(int a) {
        // this gives xor from 0 to a

        if (a % 4 == 0) {
            return a;
        }
        if (a % 4 == 1) {
            return 1;
        }
        if (a % 4 == 2) {
            return a + 1;
        }
        return 0;
    }
}
