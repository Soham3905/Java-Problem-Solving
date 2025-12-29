import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetOperations {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(45);
        set.add(67);
        set.add(78);
        set.add(89);
        set.add(90);
        set.add(5);
        System.out.println(set);
        System.out.println(set.contains(45));
        System.out.println(set.contains(56));
        System.out.println(set.size());
        set.remove(67);
        System.out.println(set.size());
        set.remove(7);
        System.out.println(set);
        System.out.println(set.size());
        Object[] arr = set.toArray();
        System.out.println(Arrays.toString(arr));

        for (int ele : set) {
            System.out.print(ele + " ");
        }
        System.out.println();
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        set.add(5);
        System.out.println(set);
    }
}
