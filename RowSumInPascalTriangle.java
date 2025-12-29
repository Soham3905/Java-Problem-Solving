
public class RowSumInPascalTriangle {

    public static void main(String[] args) {
        System.out.println(rowsum(5));
        System.out.println(rowsum1(5));
    }

    static int rowsum(int row) {
        return (int) (Math.pow(2, row - 1));
    }

    static int rowsum1(int row) {
        return 1 << (row - 1);
    }
}
