
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class CustomHashMaps {
    public static void main(String[] args) {
        String name = "Soham";
        Integer s = 343259;
        System.out.println(s.hashCode());
        int num = name.hashCode();
        System.out.println(num);
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Soham", 78);
        map.put("Kunal", 89);
        map.put("Sahil", 88);
        System.out.println(map.get("Soham"));
        System.out.println(map.get("Kunal"));
        System.out.println(map.get("Sahil"));
        System.out.println(map.getOrDefault("Harsh", 99));
        System.out.println(map.containsKey("Soham"));
        System.out.println(map.containsValue(78));

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(67);
        set.add(56);
        set.add(98);
        set.add(56);
        set.add(56);

        System.out.println(set);

        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(56);
        tree.add(98);
        tree.add(56);
        tree.add(66);
        tree.add(2);
        tree.add(56);

        System.out.println(tree);

    }
}
