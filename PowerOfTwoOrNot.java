
public class PowerOfTwoOrNot {

    public static void main(String[] args) {
        System.out.println(powerOTwo(16));
        System.out.println(powerOTwo1(16));
    }

    static boolean powerOTwo(int num) {
        if (num < 2) {
            return false;
        }
        int ans = (num & (num - 1));
        return ans == 0;
    }

    static boolean powerOTwo1(int num) {
        int count = 0;
        while (num > 0) {
            int rem = num & 1;
            num = num >> 1;
            if (rem == 1) {
                count++;
            }
        }
        return count == 1;
    }
}
