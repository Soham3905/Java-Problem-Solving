
import java.util.Arrays;

public class FlipImage {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 0},
        {1, 0, 1},
        {0, 0, 0}};
        int[][] ans = flipAndInvertImage(image);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    // static int[][] flipAndInvertImage(int[][] arr) {
    //         for (int i = 0; i < arr.length; i++) {
    //             for (int j = 0 ; j < (arr.length+1)/2; j++){
    //                  // swap
    //             int temp = arr[i][j]^1;
    //             arr[i][j] = arr[i][arr.length - j - 1]^1;
    //             arr[i][arr.length - j - 1] = temp;
    //             }  
    //         }
    //     return arr;
    // }
    // By advance for loop ------->>>>>>
    static int[][] flipAndInvertImage(int[][] arr) {
        for (int[] arr1 : arr) {
            for (int j = 0; j < (arr.length + 1) / 2; j++) {
                // swap
                int temp = arr1[j] ^ 1;
                arr1[j] = arr1[arr.length - j - 1] ^ 1;
                arr1[arr.length - j - 1] = temp;
            }
        }
        return arr;
    }
}
