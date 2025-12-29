
public class CountSteps {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }

    static int numberOfSteps(int num) {
        return helperfunc(num, 0);
    }

    static int helperfunc(int num, int steps) {
        if (num == 0) {
            return steps;
        }
        if ((num & 1) == 0) {
            return helperfunc(num / 2, steps + 1);
        }
        return helperfunc(num - 1, steps + 1);
    }
}
