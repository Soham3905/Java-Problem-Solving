
public class IthBit {

    public static void main(String[] args) {
        System.out.println(getithBit(2, 1));
        System.out.println(setithBit(12, 2));
        System.out.println(clearithBit(12, 4));
        System.out.println(negativeNumber(20));
    }

    static int getithBit(int num, int i) {
        int bitmask = 1 << (i - 1);
        if ((num & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    static int setithBit(int num, int i) {
        int bitmask = 1 << (i - 1);
        return num | bitmask;
    }

    static int clearithBit(int num, int i) {
        int bitmask = ~(1 << (i - 1));
        return num & bitmask;
    }

    static int negativeNumber(int num) {
        return (~(num) + 1);
        // return num*-1;
        // return 0-num;
    }
}
