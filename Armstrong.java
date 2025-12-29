
public class Armstrong {

    public static void main(String[] args) {
        armstronginrange();
    }

    static void armstronginrange() {
        for (int i = 100; i < 1000; i++) {
            if (isarmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static boolean isarmstrong(int num) {
        int original = num;
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans = ans + (rem * rem * rem);
            num = num / 10;
        }
        return ans == original;
    }
}
