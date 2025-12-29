
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        return slow == 1;
    }

    static int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += (rem * rem);
            num = num / 10;
        }
        return ans;
    }
}
