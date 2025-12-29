public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNumber(6));
        // Another Solution ---------->>>>
        System.out.println(magicNumber2(6));
    }
    static int magicNumber(int num){
      int ans = dectobin(num);
      int result = bintodec(ans);
      return result;
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
    static int bintodec(int num) {
        int result = 0;
        int i = 1;
        while (num > 0) {
            int rem = num % 10;
            result = result + (int) (rem * Math.pow(5, i));
            i++;
            num = num / 10;
        }
        return result;
    }

    static int magicNumber2(int num){
        int ans = 0;
        int base = 5;
        while(num > 0){
           int rem = num & 1;
           ans += rem*base;
           base = base * 5;
           num = num>>1;
        }
        return ans;
    }
}
