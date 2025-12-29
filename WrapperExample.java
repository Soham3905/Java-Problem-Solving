
public class WrapperExample {

    public static void main(String[] args) {
        Integer num = 45;
        System.out.println(num);
        Integer a = 10;
        Integer b = 20;
        int c = 30;
        int d = 40;
        swap(a, b);
        swap1(c, d);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        // final int bonus = 2;
        // bonus = 3; //error.........>>>>
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        System.out.println(a);
        b = temp;
        System.out.println(b);
    }

    static void swap1(int c, int d) {
        int temp = c;
        c = d;
        System.out.println(c);
        d = temp;
        System.out.println(d);
    }
}
