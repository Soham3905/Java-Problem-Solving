
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int ans = Math.min(helper(hBars), helper(vBars));
        return ans * ans;
    }

    public int helper(int[] bars) {
        int result = 1;
        int count = 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result + 1;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(m);
        for (int ele : hFences) {
            list1.add(ele);
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(n);
        for (int ele : vFences) {
            list2.add(ele);
        }

        long result = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                int diff = Math.abs(list1.get(j) - list1.get(i));
                set.add(diff);
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                int diff = Math.abs(list2.get(j) - list2.get(i));
                if (set.contains(diff)) {
                    result = Math.max(result, diff);
                }
            }
        }

        if (result == 0) {
            return -1;
        }
        return (int) ((result * result) % 1_000_000_007);
    }

}
