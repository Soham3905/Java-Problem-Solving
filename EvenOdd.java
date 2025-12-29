
public class EvenOdd {

    public static void main(String[] args) {
        System.out.println(evenodd(4));
    }

    static boolean evenodd(int num) {
        return (num & 1) == 0;
    }
}
