
import java.util.ArrayList;

public class Factors {

    public static void main(String[] args) {
        factors1(36);
        factors2(36);
        factors3(36);
    }

    // O(n)
    static void factors1(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // O(sqrt(n))
    static void factors2(int num) {
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if ((num / i) == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + (num / i) + " ");
                }
            }
        }
        System.out.println();
    }
    // both time and space with be O(sqrt(n))

    static void factors3(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if ((num / i) == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(num / i);
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
