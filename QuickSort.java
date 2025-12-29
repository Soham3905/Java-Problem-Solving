import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10,80,30,90,40,50,70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;

        int pivot = arr[mid];

        while (start <= end) {
            // also a reason why if its already sorted it will not swap
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            // swap
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
