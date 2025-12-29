
public class DecimaltoBinary {

    public static void main(String[] args) {
        System.out.println(dectobin(4));
        System.out.println(Integer.toBinaryString(4));
    }

    static int dectobin(int num) {
        int result = 0;
        int i = 0;
        while (num > 0) {
            int rem = num % 2;
            result = result + (int) (rem * Math.pow(10, i));
            i++;
            num = num / 2;
        }
        return result;
    }
}
