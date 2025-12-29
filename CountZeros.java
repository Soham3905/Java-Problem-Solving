
public class CountZeros {

    public static void main(String[] args) {
        System.out.println(countzeros1(3090));
        System.out.println(countzeros2(0,30905));
    }

    static int countzeros1(int num) {
        int count = 0;
        while (num > 0) {
            int rem = num % 10;
            if (rem == 0) {
                count++; 
            }
            num = num / 10;
        }
        return count;
    }

    static int countzeros2(int count, int num) {
        if (num == 0) {
            return count;
        }
        int rem = num % 10;
        if (rem == 0) {
            count++;
        }
        return countzeros2(count, num / 10);
    }
}
