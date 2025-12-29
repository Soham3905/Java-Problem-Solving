
public class FiboFormula {

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(fiboFormula(i));
        }

        System.out.println(fiboFormula(50));
    }

    static long fiboFormula(int n) {
        // just for demo, use long instead
        //    return (long)((Math.pow(((1+Math.sqrt(5))/2),n)-Math.pow(((1-Math.sqrt(5))/2),n))/Math.sqrt(5));
        // same formula..either use above formula or below formula.....
        return (long) (Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
    }
}
