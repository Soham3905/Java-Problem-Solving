
import java.util.ArrayList;

public class LinearSearchUsingRecursion {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 4, 5};
        int target = 4;
        System.out.println(search(arr, target, 0));
        System.out.println(search2(arr, target, 0));
        System.out.println(searchFromLast(arr, target, arr.length - 1));
        findAllIndex(arr, target, 0);
        System.out.println(list);
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(findAllIndex2(arr, target, 0, list2));
        System.out.println(findAllIndex3(arr, target, 0));
    }

    static boolean search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || search(arr, target, index + 1);
    }

    static int search2(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return search2(arr, target, index + 1);
        }
    }

    static int searchFromLast(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return searchFromLast(arr, target, index - 1);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();

    static int findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list2) {
        if (index == arr.length) {
            return list2;
        }
        if (arr[index] == target) {
            list2.add(index);
        }
        return findAllIndex2(arr, target, index + 1, list2);
    }

    static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index) {
        ArrayList<Integer> list3 = new ArrayList<>();
        if (index == arr.length) {
            return list3;
        }
        if (arr[index] == target) {
            list3.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllIndex3(arr, target, index + 1);
        list3.addAll(ansFromBelowCalls);
        return list3;
    }
}
