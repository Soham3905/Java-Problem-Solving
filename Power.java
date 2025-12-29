
public class Power {

    public static void main(String[] args) {
        int base = 3;
        int expo = 6;
        System.out.println(power(base, expo));
    }

    static int power(int base, int expo) {
        int ans = 1;
        while (expo > 0) {
            int rem = expo & 1;
            if (rem == 1) {
                ans = ans * base;
            }
            base = base * base;
            expo = expo >> 1;
        }
        return ans;
    }
}
