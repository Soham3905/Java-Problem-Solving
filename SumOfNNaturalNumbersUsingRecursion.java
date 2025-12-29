
public class SumOfNNaturalNumbersUsingRecursion {

    public static void main(String[] args) {
        System.out.println(sum(4));
    }

    static int sum(int num) {
        if (num <= 1) {
            return num;
        }
        return num + sum(num - 1);
    }
}
