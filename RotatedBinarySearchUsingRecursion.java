
public class RotatedBinarySearchUsingRecursion {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        int target = 8;
        System.out.println(search(arr, target));
        System.out.println(search2(arr, target, 0, arr.length - 1));
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    static int search2(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target <= arr[mid]) {
                    return search2(arr, target, start, mid - 1);
                } else {
                    return search2(arr, target, mid + 1, end);
                }
            } else {
                if (target >= arr[mid] && target <= arr[end]) {
                    return search2(arr, target, mid + 1, end);
                } else {
                    return search2(arr, target, start, mid - 1);
                }
            }
        }
        return -1;
    }
}
